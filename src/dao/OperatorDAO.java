package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import model.ParkingEntryExit;
import model.RegisteredUsers;

@Repository
public class OperatorDAO {
	@Autowired
	private JdbcTemplate template;

	private java.util.Date today = new java.util.Date();
	//new java.sql.Timestamp(today.getTime())
	//private Timestamp time= new Timestamp(System.currentTimeMillis());
	private static final String getOperator 
	= "select username,password,role,fullname from regd_users where username = ? and password = ? and role=?";
	
	private static final String getParkingId = "SELECT PARKING_SEQ.NEXTVAL FROM DUAL";
	
	private static final String insertEntry="INSERT INTO PARKING_ENTRY_EXIT"
			+ "VALUES(:parkingid,:slot,:vehicleno,:mobilenumber,:entrytime,:exittime,:bill,:payment,:regd)";
	
	private static final String GET_SLOT_ID
										= "SELECT SLOT_ID FROM PARKING_ENTRY_EXIT WHERE PARKING_ID =?";
	
	public RegisteredUsers getUser(String username,String password,String role) {
		System.out.println("GETTING QUERY.");
		return template.queryForObject(getOperator,new UserMapper(),username,password,role);
	}
	
	public int getParkingId(){
		return template.queryForObject(getParkingId, Integer.class);
	}
	
	public  List<ParkingEntryExit> getparkingDetails(int parkingid){
		String query="select parking_id,slot_id,vehicle_reg_no,driver_mobile,entry_time from parking_entry_exit "
				+ "where parking_id="+parkingid+" and exit_time is null";
		return template.query(query,new ParkingIdMapper());
	}
	
	public  List<ParkingEntryExit> getVehicleDetails(String vehicleRegNo){
		String query="select parking_id,slot_id,vehicle_reg_no,driver_mobile,entry_time from parking_entry_exit "
				+ "where vehicle_reg_no='"+vehicleRegNo+"' and exit_time is null";
		return template.query(query,new ParkingIdMapper());
	}
	
	public int[] insertEntry(int parkingid,int slot,String vehicleno,long mobilenumber){
		String update_parking_slots="update parking_slots set status='PARKED' WHERE SLOT_ID="+slot+"";
		String INSERT_VEHICLE_ENTRY="insert into parking_entry_exit(parking_id,slot_id,vehicle_reg_no,driver_mobile,entry_time) "
				+ "values("+parkingid+","+slot+",'"+vehicleno+"',"+mobilenumber+",CURRENT_TIMESTAMP)";
		return template.batchUpdate(INSERT_VEHICLE_ENTRY,update_parking_slots);
	}

	public int[] updateExit(int parkingid,double billAmount,String paymentMode,int regdid){
		String slotIdSql = "selcet slot_id from parking_entry_exit where parking_id="+parkingid;
		System.out.println("-----------This is updateExit");
		int slotId = getSlotId(parkingid);
		System.out.println("Int slotId "+slotId);
		String update_parking_slots="update parking_slots set status='EMPTY' WHERE SLOT_ID="+slotId;
		String INSERT_VEHICLE_ENTRY="update parking_entry_exit set EXIT_TIME=CURRENT_TIMESTAMP,"
				+ "BILL_AMOUNT="+billAmount+",PAYMENT_MODE='"+paymentMode+"',"
						+ "REGISTRATION_ID="+regdid+" where parking_id="+parkingid+"";
		return template.batchUpdate(INSERT_VEHICLE_ENTRY,update_parking_slots);
	}
	
	private int getSlotId(int parkingid){
		return template.queryForObject(GET_SLOT_ID, Integer.class,parkingid);
	}
	private class UserMapper implements RowMapper<RegisteredUsers> {

		@Override
		public RegisteredUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("TRYING TO CREATE OBJECT.");
			return new RegisteredUsers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
	}
	private class ParkingIdMapper implements RowMapper<ParkingEntryExit> {

		@Override
		public ParkingEntryExit mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("TRYING TO CREATE OBJECT.");
			return new ParkingEntryExit(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getLong(4), rs.getTimestamp(5));
		}
	}
}
