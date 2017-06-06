package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ManagerDAO;
import dao.OperatorDAO;
import dao.ParkingSlotsDAO;
import model.ParkingEntryExit;
import model.ParkingSlots;
import model.RegisteredUsers;

@Controller
public class ManagerController {
	@Autowired
	private ParkingSlotsDAO parkingSlotsDao;

	@Autowired
	private ManagerDAO managerDAO ;

	@RequestMapping(value="/manager/login")
	public String operatorLogin(@RequestParam("username") String username,
								@RequestParam("password") String password,
								@RequestParam("role") String role,
								HttpServletRequest request,
								HttpSession session,
								Model model){
		System.out.println(username);
		System.out.println(password);
		System.out.println(role);

		try {
			RegisteredUsers userdetails = managerDAO.getUser(username,password,role);
			if(userdetails == null){
				model.addAttribute("msg", "Invalid Credentials");
				return "home";
			}
			
			session.invalidate();
			request.getSession();
			
			model.addAttribute("msg", "UserName Password matched");

			System.out.println("user Name : " + userdetails.getUserName());
			System.out.println("full Name : " + userdetails.getFullName());
			return "manager/managerhome";
		} catch (Exception e) {
			model.addAttribute("msg", "No user Found");
			return "home";
		}
		
	}
	@RequestMapping(value="/addUser")
	public String addUser(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "manager/addUser";
	}
	
	@RequestMapping(value="/managerhome")
	public String addAnotherUser(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "manager/managerhome";
	}
	
	@RequestMapping(value="/addUserResult")
	public String addUserResult(@RequestParam("userName") String userName,
								@RequestParam("password") String password,
								@RequestParam("fullName") String fullName,
								HttpServletRequest request,
								Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		
		List<RegisteredUsers> registeredUser = managerDAO.checkUser(userName);
		if(!registeredUser.isEmpty()){
			model.addAttribute("msg", "Username Already Exists !!");
			return "manager/addUser";
		}
		int userInserted = managerDAO.addNewUser(userName, password, fullName);
		if(userInserted>0){
			model.addAttribute("msg", "User inserted successfully");
		}
		else{
			model.addAttribute("msg", "User couldn't be inserted");
		}
		model.addAttribute("userName", userName);
		model.addAttribute("password", password);
		model.addAttribute("fullName", fullName);
		return "manager/addUserResult";
	}
	
	@RequestMapping(value="/deleteUserForm")
	public String deleteUserForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<RegisteredUsers> allOperators = managerDAO.getAllOperators();
		model.addAttribute("allOperators", allOperators);
		return "manager/deleteUserForm";
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public String deleteUser(@RequestParam("allOperators") String[] allOperators,
							HttpServletRequest request,
							Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		int noOfOperators = allOperators.length;
		if(noOfOperators<1){
			model.addAttribute("msg","Select atleast one operator to delete.");
			return "manager/deleteUserForm";
		}
		System.out.println(noOfOperators);
		for(int i=0;i<noOfOperators;i++){
			System.out.println(allOperators[i]);
			managerDAO.deleteUser(allOperators[i]);
		}
		model.addAttribute("allOperators", allOperators);
		return "manager/deleteUser";
	}
	
	@RequestMapping(value="/resetPasswordForm")
	public String resetPasswordForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<RegisteredUsers> allOperators = managerDAO.getAllOperators();
		model.addAttribute("allOperators", allOperators);
		return "manager/resetPasswordForm";
	}
	
	@RequestMapping(value="resetPassword")
	public String deleteUser(@RequestParam("userName") String userName,
							 @RequestParam("newPassword") String newPassword,
							 HttpServletRequest request,
							Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		int passwordReset = managerDAO.resetPassword(userName, newPassword);
		if(passwordReset>0){
			model.addAttribute("msg", "Password Successfully Updated !!");
			model.addAttribute("newPassword", newPassword);
			model.addAttribute("userName", userName);
			return "manager/resetPassword";
		}
		else{
			model.addAttribute("msg", "Password Couldn't be Updated !!");
			return "manager/resetPasswordForm";
		}		
	}
	
	@RequestMapping(value="/addNewSlotForm")
	public String addNewSlotForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "manager/addNewSlotForm";
	}
	
	@RequestMapping(value="/addNewSlot")
	public String addNewSlot(@RequestParam("slotId") int slotId,
							 @RequestParam("vehicleType") String vehicleType,
							 @RequestParam("floor") String floor,
							 HttpServletRequest request,
							Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		if(!managerDAO.checkExistingSlots(slotId).isEmpty()){
			model.addAttribute("msg", "Slot Id already Exists");
			return "manager/addNewSlotForm";
		}
		if(managerDAO.insernewSlot(slotId, vehicleType, floor)!=0){
			model.addAttribute("msg", "New Slot Created");
			model.addAttribute("floor", floor);
			model.addAttribute("vehicleType", vehicleType);
			model.addAttribute("slotId", slotId);
			return "manager/addNewSlot";
		}
		else{
			model.addAttribute("msg", "New SlotCouldn't be created");
			return "manager/addnewSlotForm";
		}
	}
	
	@RequestMapping(value="/blockSlotForm")
	public String blockSlotForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingSlots> allEmptySlots = managerDAO.getAllEmptySlots();
		model.addAttribute("allEmptySlots", allEmptySlots);
		return "manager/blockSlotForm";
	}
	
	@RequestMapping(value="/blockSlotConfirm")
	public String blockSlotConfirm(@RequestParam("slotId") String slotId,
									HttpServletRequest request,
									Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		model.addAttribute("slotId", slotId);
		return "manager/blockSlotConfirm";
	}
	
	@RequestMapping(value="/blockSlot")
	public String blockSlot(@RequestParam("slotId") int slotId,
							HttpServletRequest request,
							Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		if(managerDAO.bookSlot(slotId)>0){
			model.addAttribute("msg","Slot Booked !!" );
			model.addAttribute("slotId", slotId);
			return "manager/blockSlot";
			
		}
		else{
			model.addAttribute("msg","Couldn't book the Slot");
			return "manager/blockSlotForm";
		}
	}
	
	@RequestMapping(value="/newRegistrationForm")
	public String newRegistrationForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		model.addAttribute("registrationId", managerDAO.getRegistrationId());
		return "manager/newRegistrationForm";
	}
	
	@RequestMapping(value="/newRegistration")
	public String newRegistration(@RequestParam("vehicleType") String vehicleType,
								  @RequestParam("customerName") String customerName,
								  @RequestParam("registrationId") int registrationId,
								  @RequestParam("driverMobileNumber") long driverMobileNumber,
								  @RequestParam("vehicleRegistrationNumber") String vehicleRegistrationNumber,
								  @RequestParam("price") int price,
								  HttpServletRequest request,
								  Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		if(managerDAO.addNewRegistration(registrationId, customerName, vehicleRegistrationNumber, driverMobileNumber, vehicleType,price)>0){
			model.addAttribute("date",managerDAO.getRegisteredValidDate(registrationId));
			model.addAttribute("msg", "Registration Completed.");
			model.addAttribute("registrationId", registrationId);
			model.addAttribute("vehicleType", vehicleType);
			model.addAttribute("customerName", customerName);
			model.addAttribute("driverMobileNumber", driverMobileNumber);
			model.addAttribute("vehicleRegistrationNumber", vehicleRegistrationNumber);
			model.addAttribute("price", price);
			return "manager/newRegistration";
		}
		else{
			model.addAttribute("msg", "Registration Failed Try Again");
			return "manager/newRegistrationForm";
		}
	}
	
	@RequestMapping(value="/renewRegistrationForm")
	public String renewRegistrationForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "manager/renewRegistrationForm";
	}
	
	@RequestMapping(value="/renewRegistration")
	public String renewRegistration(@RequestParam("registrationId") int registrationId,
									HttpServletRequest request,
									Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		if(managerDAO.renewRegistration(registrationId)>0){
			model.addAttribute("msg","Package Successfully Renewed");
			return "manager/renewRegistration";
		}
		else{
			model.addAttribute("msg","Package Couldn't be Renewed. Try Again !!");
			return "manager/renewRegistrationForm";
		}
	}
	
	@RequestMapping(value="/currentlyParkedVehicles")
	public String getCurrentlyParkedVehicles(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingEntryExit> parkedVehicles = managerDAO.getParkedVehicles();
		System.out.println(parkedVehicles.size());
		model.addAttribute("parkedVehicles", parkedVehicles);
		return "manager/currentlyParkedVehicles";
	}
	
	@RequestMapping(value="/previouslyParkedVehiclesForm")
	public String previouslyParkedVehiclesForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "manager/previouslyParkedVehiclesForm";
	}

	@RequestMapping(value="/previouslyParkedVehicles")
	public String previouslyParkedVehicles(@RequestParam("vehicleRegNo") String vehicleRegNo,
										   HttpServletRequest request,
										   Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingEntryExit> previouslyParkedVehicles = managerDAO.getPreviouslyParkedVehicles(vehicleRegNo);
		if(previouslyParkedVehicles.size()>0){
			model.addAttribute("previousVehicles", previouslyParkedVehicles);
			return "manager/previouslyParkedVehicles";
		}
		else{
			model.addAttribute("msg", "No result found for this Number. Try Again !!");
			return "manager/previouslyParkedVehiclesForm";
		}
	}
	
	@RequestMapping(value="/unblockSlotForm")
	public String unblockSlotForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<ParkingSlots> blockedSlots = managerDAO.checkBlockedSlots();
		model.addAttribute("blockedSlots", blockedSlots);
		return "manager/unblockSlotForm";
	}
	
	@RequestMapping(value="/unblockSlotConfirm")
	public String unblockSlotConfirm(@RequestParam("slotId") String slotId,
									HttpServletRequest request,
									Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		model.addAttribute("slotId", slotId);
		return "manager/unblockSlotConfirm";
	}
	
	@RequestMapping(value="/unblockSlot")
	public String unblockSlot(@RequestParam("slotId") int slotId,
							HttpServletRequest request,
							Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		if(managerDAO.unblockSlot(slotId)>0){
			model.addAttribute("msg","Slot Unblocked !!" );
			model.addAttribute("slotId", slotId);
			return "manager/unblockSlot";
			
		}
		else{
			model.addAttribute("msg","Couldn't Unblock the Slot");
			return "manager/blockSlotForm";
		}
	}
	
}


