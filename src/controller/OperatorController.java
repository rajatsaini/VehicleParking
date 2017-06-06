package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.OperatorDAO;
import dao.ParkingSlotsDAO;
import model.ParkingEntryExit;
import model.ParkingSlots;
import model.RegisteredUsers;

@Controller
public class OperatorController {
	
	@Autowired
	private ParkingSlotsDAO parkingSlotsDao;
	
	@Autowired
	private OperatorDAO operationDAO;
	
	@RequestMapping(value="/operator/login")
	public String operatorLogin(@RequestParam("username") String username,
								@RequestParam("password") String password,
								@RequestParam("role") String role,
								HttpSession session,
								HttpServletRequest request,
								Model model){
		System.out.println(username);
		System.out.println(password);
		System.out.println(role);
		
		try {
			RegisteredUsers userdetails = operationDAO.getUser(username,password,role);
			if(userdetails == null){
				model.addAttribute("msg", "Invalid Credentials");
				return "home";
			}
			
			session.invalidate();
			request.getSession();
			
			System.out.println("user Name : " + userdetails.getUserName());
			System.out.println("full Name : " + userdetails.getFullName());
			return "operator/PreParkingProcess";
		} catch (Exception e) {
			model.addAttribute("msg", "No user Found");
			return "home";
		}
		
	}

	@RequestMapping(value="/PreParkingProcess")
	public String searchSlots(@RequestParam("vehicleType") String vehicleType,
								@RequestParam("customerType") String customerType,
								HttpServletRequest request,
								Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingSlots> parkingSlots = parkingSlotsDao.getEmptyParkingSlots(vehicleType);
		model.addAttribute("parkingSlots",parkingSlots);
		model.addAttribute("vehicleType", vehicleType);
		model.addAttribute("customerType", customerType);
		return "operator/searchSlotResult";
	}
	
	@RequestMapping(value="/preParkingProcess")
	public String operatorHome(HttpServletRequest request,
								Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "operator/PreParkingProcess";
	}
	
	@RequestMapping(value="/allocateParking")
	public String searchSlots(@RequestParam("slotId") int slotId,
							  @RequestParam("vehicleType") String vehicleType,
							  HttpServletRequest request,
								Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		model.addAttribute("parkingId",operationDAO.getParkingId());
		model.addAttribute("slotId",slotId);
		model.addAttribute("vehicleType", vehicleType);
		return "operator/AllocateParking";
	}
	
	@RequestMapping(value="/ticketGenerate")
	public String ticketPrinting(@RequestParam("slotId") int slotId,
								 @RequestParam("parkingId") int parkingId,
								 @RequestParam("vehicleNumber") String vehicleNumber,
								 @RequestParam("mobileNumber") long mobileNumber,
								 @RequestParam("vehicleType") String vehicleType,
								 HttpServletRequest request,
								 Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingEntryExit> parkingEntryExit = operationDAO.getVehicleDetails(vehicleNumber);
		if(!parkingEntryExit.isEmpty()){
			System.out.println("Vehicle Number Exists.");
			model.addAttribute("parkingId",parkingId);
			model.addAttribute("slotId",slotId);
			model.addAttribute("vehicleType",vehicleType);
			model.addAttribute("msg", "Vehicle Number already Parked");
			return "operator/AllocateParking";
		}
		operationDAO.insertEntry(parkingId,slotId, vehicleNumber, mobileNumber);
		model.addAttribute("parkingId",parkingId);
		model.addAttribute("slotId",slotId);
		model.addAttribute("vehicleNumber",vehicleNumber);
		model.addAttribute("mobileNumber",mobileNumber);
		model.addAttribute("vehicleType",vehicleType);
		return "operator/ticketGenerate";
	}
	
	@RequestMapping(value="/deAllocate")
	public String billPrinting(@RequestParam("parkingId") int parkingId ,
							   HttpServletRequest request,
							   Model model){
		
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingEntryExit> parkingEntryExit=operationDAO.getparkingDetails(parkingId);
		if(parkingEntryExit.isEmpty()){
			model.addAttribute("msg", "Parking Id hasn't been created or already deallocated");
			return "operator/PreParkingProcess";
		}
		model.addAttribute("parkingId",parkingEntryExit.get(0).getParkingId());
		model.addAttribute("slotId",parkingEntryExit.get(0).getSlotId());
		model.addAttribute("vehicleNumber",parkingEntryExit.get(0).getVehicleRegNo());
		model.addAttribute("mobileNumber",parkingEntryExit.get(0).getDriverMobileNumber());
		int sid=parkingEntryExit.get(0).getSlotId();
		String vehicleType;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); 
		Date d=parkingEntryExit.get(0).getEntryTime();
		dateFormat.format(d);
		System.out.println(d);
		long diff = date.getTime() - d.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
		model.addAttribute("entryTime",d);
		model.addAttribute("exitTime", date);
		model.addAttribute("numberofhours", diffHours);
		double bill=0;
		if(sid<150){
			vehicleType="TWO";
			bill=15;
			bill=bill+15*diffHours;
		}else{
			 vehicleType="CAR";
			 bill=30;
			 bill=bill+30*diffHours;
		}
		model.addAttribute("vehicleType",vehicleType);
		model.addAttribute("bill", bill);
		
		return "operator/ProcessBill";
	}
	
	@RequestMapping(value="/billGenerate")
	public String billGenerateForm(@RequestParam("paymentMode") String paymentMode,
			@RequestParam("slotId") int slotId,
			@RequestParam("parkingId") int parkingId,
			@RequestParam("vehicleNumber") String vehicleNumber,
			@RequestParam("mobileNumber") long mobileNumber,
			@RequestParam("vehicleType") String vehicleType,
			@RequestParam("entryTime") String entryTime,
			@RequestParam("exitTime") String exitTime,
			@RequestParam("numberofhours") int numberofhours,
			@RequestParam("bill") double bill,
			HttpServletRequest request,
									Model model){
		
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		int regdid=0;
		model.addAttribute("slotId", slotId);
		model.addAttribute("parkingId", parkingId);
		model.addAttribute("vehicleNumber", vehicleNumber);
		model.addAttribute("mobileNumber", mobileNumber);
		model.addAttribute("vehicleType", vehicleType);
		model.addAttribute("entryTime", entryTime);
		model.addAttribute("exitTime", exitTime);
		model.addAttribute("numberofhours", numberofhours);
		model.addAttribute("bill", bill);
		model.addAttribute("paymentMode", paymentMode);
		System.out.println("---------------");
		System.out.println(paymentMode);
		operationDAO.updateExit(parkingId, bill, paymentMode,regdid);
		
		return "operator/billGenerate";
	}
	
}
