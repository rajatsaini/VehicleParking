package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.ParkingSlots;



@Repository
public class ParkingSlotsDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	private static final String SLOTID_COUNT = 
			"select count(*) from PARKING_SLOTS";
	
	private static final String VEHICLE_INSERT = 
			"insert into PARKING_SLOTS WHERE VEHICLE_TYPE= ?,?";
	
	private static final String SLOT_GET =
			"SELECT STATUS, FROM PARKING_SLOTS WHERE STATUS= ?,?,?,?";
	
	private static final String GET_EMPTY_SLOTS =
			"SELECT * FROM PARKING_SLOTS WHERE VEHICLE_TYPE=? AND STATUS='EMPTY'";
	
	public  int getSlotId(){
		return template.queryForObject("select count(*) from PARKING_SLOTS ", Integer.class);
	}
	
	public int insertVehicle(String vehicleType){
		return template.update(VEHICLE_INSERT, 
				vehicleType);
	}
	
	public List<ParkingSlots> getEmptyParkingSlots(String vehicleType){
		return template.query(GET_EMPTY_SLOTS, new ParkingSlotsMapper(),vehicleType);
	}
	
	private class ParkingSlotsMapper implements RowMapper<ParkingSlots>{

		@Override
		public ParkingSlots mapRow(ResultSet rs, int arg1) throws SQLException {
			return new ParkingSlots(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
		
	}
}
