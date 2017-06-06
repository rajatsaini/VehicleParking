package model;

import java.sql.Timestamp;
import java.util.Date;

public class ParkingEntryExit {
	private int parkingId;
	private int slotId;
	private String vehicleRegNo;
	private long driverMobileNumber;
	private Timestamp entryTime;
	private Timestamp exitTime;

	public ParkingEntryExit(){}
	
	public ParkingEntryExit(int parkingId, int slotId, String vehicleRegNo,
							long driverMobile, Timestamp entryTime){
		super();
		this.parkingId = parkingId;
		this.slotId = slotId;
		this.vehicleRegNo = vehicleRegNo;
		this.driverMobileNumber = driverMobile;
		this.entryTime = entryTime;
	}
	
	public ParkingEntryExit(int parkingId, int slotId, String vehicleRegNo,
							long driverMobile, Timestamp entryTime,Timestamp exitTime){
		super();
		this.parkingId = parkingId;
		this.slotId = slotId;
		this.vehicleRegNo = vehicleRegNo;
		this.driverMobileNumber = driverMobile;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
	}

	public ParkingEntryExit(int slotId, String vehicleRegistrationNumber, long driverMobile, Timestamp entryTime) {
		this.slotId = slotId;
		this.vehicleRegNo = vehicleRegistrationNumber;
		this.driverMobileNumber = driverMobile;
		this.entryTime = entryTime;
	}



	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	public long getDriverMobileNumber() {
		return driverMobileNumber;
	}
	public void setDriverMobileNumber(long driverMobile) {
		this.driverMobileNumber = driverMobile;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}

	public Timestamp getExitTime() {
		return exitTime;
	}

	public void setExitTime(Timestamp exitTime) {
		this.exitTime = exitTime;
	}

}
