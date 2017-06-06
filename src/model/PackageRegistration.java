package model;

import java.util.Date;

public class PackageRegistration {

	private int registrationId;
	private String customerName;
	private String vehicleRegistrationNumber;
	private int driverMobileNumber;
	private Date validUpTo;

	public PackageRegistration(){}

	public PackageRegistration(int registrationId, String customerName, String vehicleRegistrationNumber,
			int driverMobile, Date validUpTo) {
		super();
		this.registrationId = registrationId;
		this.customerName = customerName;
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
		this.driverMobileNumber = driverMobile;
		this.validUpTo = validUpTo;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public int getDriverMobileNumber() {
		return driverMobileNumber;
	}

	public void setDriverMobileNumber(int driverMobile) {
		this.driverMobileNumber = driverMobile;
	}

	public Date getValidUpTo() {
		return validUpTo;
	}

	public void setValidUpTo(Date validUpTo) {
		this.validUpTo = validUpTo;
	}


}
