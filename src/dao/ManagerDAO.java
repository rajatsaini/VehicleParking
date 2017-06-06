package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.ParkingEntryExit;
import model.ParkingSlots;
import model.RegisteredUsers;

@Repository
public class ManagerDAO {
	@Autowired
	private JdbcTemplate template;

	private static final String getManager = "select username,password,role,fullname from regd_users where username = ? and password = ? and role=?";



	private static final String CHECK_USER 
	= "SELECT USERNAME,PASSWORD,ROLE,FULLNAME FROM REGD_USERS "
			+ "WHERE USERNAME=?";

	private static final String ADD_NEW_USER 
	= "INSERT INTO REGD_USERS VALUES(?,?,'OPERATOR',?)";

	private static final String GET_ALL_OPERATOR
	= "SELECT * FROM REGD_USERS WHERE ROLE='OPERATOR'";

	private static final String DELETE_OPERATOR
	= "DELETE FROM REGD_USERS WHERE USERNAME=?";

	private static final String UPDATE_OPERATOR_PASSWORD
	= "UPDATE REGD_USERS SET PASSWORD = ? WHERE USERNAME = ?";

	private static final String ALL_EMPTY_SLOTS
	= "SELECT * FROM PARKING_SLOTS WHERE STATUS = 'EMPTY'";

	private static final String CHECK_SLOT 
	= "SELECT * FROM PARKING_SLOTS WHERE SLOT_ID=?";

	private static final String INSERT_NEW_SLOT 
	= "INSERT INTO PARKING_SLOTS VALUES(?,?,'EMPTY',?)";

	private static final String BOOK_SLOT
								= "UPDATE PARKING_SLOTS SET STATUS='BLOCKED' WHERE SLOT_ID=?";

	private static final String GET_REGISTRATION_SEQ 
								= "SELECT REGISTRATION_ID_SEQ.NEXTVAL FROM DUAL";

	private static final String GET_REGISTERED_PACKAGE
								= "SELECT VALID_UPTO FROM PACKAGE_REGN WHERE REGISTRATION_ID = ?";
	
	private static final String GET_PARKED_VEHICLES_DETAILS
								= "SELECT SLOT_ID,VEHICLE_REG_NO,DRIVER_MOBILE,ENTRY_TIME FROM PARKING_ENTRY_EXIT "
										+ "WHERE EXIT_TIME IS NULL";
	
	private static final String PREVIOUSLY_PARKED_VEHICLES 
								= "SELECT * FROM PARKING_ENTRY_EXIT "
										+ "WHERE VEHICLE_REG_NO = ? AND EXIT_TIME IS NOT NULL";
	
	private static final String BLOCKED_SLOTS 
								= "SELECT * FROM PARKING_SLOTS WHERE STATUS = 'BLOCKED'";
	
	private static final String UNBLOCK_SLOT
								= "UPDATE PARKING_SLOTS SET STATUS='EMPTY' WHERE SLOT_ID=?";
	
	public RegisteredUsers getUser(String username,String password,String role) {
		return template.queryForObject(getManager,new UserMapper(),username,password,role);
	}

	public List<RegisteredUsers> checkUser(String userName){
		return template.query(CHECK_USER, new UserMapper(),userName);
	}

	public int addNewUser(String userName,String password,String fullName){
		return template.update(ADD_NEW_USER,userName,password,fullName);
	}

	public int deleteUser(String userName){
		return template.update(DELETE_OPERATOR,userName);
	}

	public int resetPassword(String userName,String password){
		return template.update(UPDATE_OPERATOR_PASSWORD,password,userName);
	}

	public List<RegisteredUsers> getAllOperators(){
		return template.query(GET_ALL_OPERATOR, new UserMapper());
	}

	public List<ParkingSlots> checkExistingSlots(int slotId){
		return template.query(CHECK_SLOT, new SlotMapper(),slotId);
	}
	
	public List<ParkingSlots> checkBlockedSlots(){
		return template.query(BLOCKED_SLOTS, new SlotMapper());
	}

	public List<ParkingSlots> getAllEmptySlots(){
		return template.query(ALL_EMPTY_SLOTS, new SlotMapper());
	}

	public int insernewSlot(int slotId,String vehicleType,String floor){
		return template.update(INSERT_NEW_SLOT,slotId,vehicleType,floor);
	}

	public int bookSlot(int slotId){
		return template.update(BOOK_SLOT,slotId);
	}
	
	public int unblockSlot(int slotId){
		return template.update(UNBLOCK_SLOT,slotId);
	}

	public int getRegistrationId(){
		return template.queryForObject(GET_REGISTRATION_SEQ,Integer.class);
	}

	public int addNewRegistration(int registrationId,
			String customerName,
			String vehicleRegistrationNumber,
			long driverMobileNumber,
			String vehicleType,int price){
		Date date = new Date();  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);  // number of days to add
		String validUptoDate = sdf.format(c.getTime());
		System.out.println(validUptoDate);
		String sql = "INSERT INTO PACKAGE_REGN VALUES("+registrationId+",'"+customerName+"','"
				+vehicleRegistrationNumber+"',"
				+driverMobileNumber
				+",TO_DATE('"+validUptoDate+"','yyyy/MM/dd'),'"+vehicleType+"',"+price+")";

		return template.update(sql);

	}

	public int renewRegistration(int registrationId){
		Date date = new Date();  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);  // number of days to add
		String validUptoDate = sdf.format(c.getTime());
		System.out.println(validUptoDate);
		String sql = "UPDATE PACKAGE_REGN SET VALID_UPTO =TO_DATE('"
				+validUptoDate+"','yyyy/MM/dd') WHERE REGISTRATION_ID="
				+registrationId;
		return template.update(sql);
	}

	public Date getRegisteredValidDate(int registeredId){
		return template.queryForObject(GET_REGISTERED_PACKAGE,Date.class,registeredId);
	}
	
	public List<ParkingEntryExit> getParkedVehicles(){
		return template.query(GET_PARKED_VEHICLES_DETAILS,new ParkingDetails());
	}
	
	public List<ParkingEntryExit> getPreviouslyParkedVehicles(String vehicleRegNo){
		return template.query(PREVIOUSLY_PARKED_VEHICLES,new PreviouslyParkedDetails(),vehicleRegNo);
	}
	
	private class PreviouslyParkedDetails implements RowMapper<ParkingEntryExit>{
		@Override
		public ParkingEntryExit mapRow(ResultSet rs, int arg1) throws SQLException {
			return new ParkingEntryExit(rs.getInt(1),rs.getInt(2),
										rs.getString(3),rs.getLong(4),
										rs.getTimestamp(5),rs.getTimestamp(6));
		}
		
	}
	
	private class ParkingDetails implements RowMapper<ParkingEntryExit>{

		@Override
		public ParkingEntryExit mapRow(ResultSet rs, int arg1) throws SQLException {
			return new ParkingEntryExit(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getTimestamp(4));
		}
	}

	private class SlotMapper implements RowMapper<ParkingSlots>{
		@Override
		public ParkingSlots mapRow(ResultSet rs, int arg1) throws SQLException {
			return new ParkingSlots(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}		
	}
	private class UserMapper implements RowMapper<RegisteredUsers> {

		@Override
		public RegisteredUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("TRYING TO CREATE OBJECT.");
			return new RegisteredUsers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
	}
}

