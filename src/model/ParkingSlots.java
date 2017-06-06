package model;

public class ParkingSlots {
	private int slotId;
	private String vehicleType;
	private String status;
	private String floor;
	
	public ParkingSlots(){}
	
	public ParkingSlots(int slotId, String vehicleType, String status, String floor) {
		super();
		this.slotId = slotId;
		this.vehicleType = vehicleType;
		this.status = status;
		this.floor = floor;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}


	}
