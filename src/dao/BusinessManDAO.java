package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.ParkingEntryExit;
import model.RegisteredUsers;

@Repository
public class BusinessManDAO {
	@Autowired
	private JdbcTemplate template;

	private static final String GET_BUSSINESSMAN 
	= "select username,password,role,fullname from regd_users "
			+ "where username = ? and password = ? and role=?";

	private static final String CHECK_MANAGER 
	= "SELECT USERNAME,PASSWORD,ROLE,FULLNAME FROM REGD_USERS "
			+ "WHERE USERNAME=?";

	private static final String ADD_NEW_MANAGER 
	= "INSERT INTO REGD_USERS VALUES(?,?,'MANAGER',?)";

	private static final String GET_ALL_MANAGER
	= "SELECT * FROM REGD_USERS WHERE ROLE='MANAGER'";

	private static final String DELETE_MANAGER
	= "DELETE FROM REGD_USERS WHERE USERNAME=?";
	
	private static final String REVENUE
	= "SELECT SUM(BILL_AMOUNT) FROM PARKING_ENTRY_EXIT";
	
	private static final String REVENUE_BY_TWO_WHEELER
	= "SELECT SUM(BILL_AMOUNT) FROM PARKING_ENTRY_EXIT WHERE SLOT_ID BETWEEN 101 AND 150";
	
	private static final String REVENUE_BY_CAR
	= "SELECT SUM(BILL_AMOUNT) FROM PARKING_ENTRY_EXIT WHERE SLOT_ID BETWEEN 201 AND 325";
	
	public RegisteredUsers getManager(String username,String password,String role) {
		return template.queryForObject(GET_BUSSINESSMAN,new UserMapper(),username,password,role);
	}

	public List<RegisteredUsers> checkManager(String userName){
		return template.query(CHECK_MANAGER, new UserMapper(),userName);
	}

	public int addNewManager(String userName,String password,String fullName){
		return template.update(ADD_NEW_MANAGER,userName,password,fullName);
	}

	public int deleteManager(String userName){
		return template.update(DELETE_MANAGER,userName);
	}



	public List<RegisteredUsers> getAllManagers(){
		return template.query(GET_ALL_MANAGER, new UserMapper());
	}

	private class UserMapper implements RowMapper<RegisteredUsers> {

		@Override
		public RegisteredUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("TRYING TO CREATE OBJECT.");
			return new RegisteredUsers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
	}

	
	public int getBillAmount(){
		String REVENUE_BY_PACKAGE="select sum(price) from package_regn";
		return template.queryForObject(REVENUE_BY_PACKAGE,Integer.class);
		
	}
	public int getBillAmountYear(){
		String REVENUE_BY_PACKAGE="select sum(price) from package_regn where VALID_UPTO like '%-17%'";
		return template.queryForObject(REVENUE_BY_PACKAGE,Integer.class);
		
	}
	
	public int getBillAmountOfGuest(){
		String REVENUE_BY_PACKAGE="select sum(BILL_AMOUNT) from parking_entry_exit";
		return template.queryForObject(REVENUE_BY_PACKAGE,Integer.class);
		
	}
	public int getBillAmountOfGuestYear(){
		String REVENUE_BY_PACKAGE="select sum(BILL_AMOUNT) from parking_entry_exit where ENTRY_TIME like  '%-17%'";
		return template.queryForObject(REVENUE_BY_PACKAGE,Integer.class);
		
	}
	public int getBillAmountOfGuestTwo(){
		String REVENUE_BY_PACKAGE="select sum(BILL_AMOUNT) from parking_entry_exit where SLOT_ID<151";
		return template.queryForObject(REVENUE_BY_PACKAGE,Integer.class);
		
	}
	public int getBillAmountOfGuestCar(){
		String REVENUE_BY_PACKAGE="select sum(BILL_AMOUNT) from parking_entry_exit where SLOT_ID>199";
		return template.queryForObject(REVENUE_BY_PACKAGE,Integer.class);
		
	}

}




