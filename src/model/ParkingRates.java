package model;

public class ParkingRates {

	private String vehicleType;
	private double ratePerHour;

	public ParkingRates(){}

	public ParkingRates(String vehicleType, double ratePerHour) {
		super();
		this.vehicleType = vehicleType;
		this.ratePerHour = ratePerHour;
	}

	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public double getRatePerHour() {
		return ratePerHour;
	}
	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

}
