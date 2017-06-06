package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BusinessManDAO;
import dao.OperatorDAO;
import dao.ParkingSlotsDAO;
import model.ParkingSlots;
import model.RegisteredUsers;

@Controller
public class BusinessManController {
	@Autowired
	private ParkingSlotsDAO parkingSlotsDao;
	
	@Autowired
	private BusinessManDAO businessManDAO;
	
	@RequestMapping(value="/businessMan/login")
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
			RegisteredUsers userdetails = businessManDAO.getManager(username,password,role);
			if(userdetails == null){
				model.addAttribute("msg", "Invalid Credentials");
				return "home";
			}
			
			session.invalidate();
			request.getSession();
			
			System.out.println("user Name : " + userdetails.getUserName());
			System.out.println("full Name : " + userdetails.getFullName());
			model.addAttribute("msg", "UserName Password matched");
			return "businessMan/businessmanhome";
		} catch (Exception e) {
			model.addAttribute("msg", "No user Found");
			return "home";
		}
	}
	@RequestMapping(value="/addManager")
	public String addUser(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "businessMan/addManager";
	}
	
	@RequestMapping(value="/businessmanhome")
	public String addAnotherUser(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		return "businessMan/businessmanhome";
	}
	
	@RequestMapping(value="/addManagerResult")
	public String addUserResult(@RequestParam("userName") String userName,
								@RequestParam("password") String password,
								@RequestParam("fullName") String fullName,
								HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		
		List<RegisteredUsers> registeredUser = businessManDAO.checkManager(userName);
		if(!registeredUser.isEmpty()){
			model.addAttribute("msg", "Manager Already Exists !!");
			return "businessMan/addManager";
		}
		int userInserted = businessManDAO.addNewManager(userName, password, fullName);
		if(userInserted>0){
			model.addAttribute("msg", "Manager inserted successfully");
		}
		else{
			model.addAttribute("msg", "Manager couldn't be inserted");
		}
		model.addAttribute("userName", userName);
		model.addAttribute("password", password);
		model.addAttribute("fullName", fullName);
		return "businessMan/addManagerResult";
	}
	
	@RequestMapping(value="/deleteManagerForm")
	public String deleteUserForm(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		List<RegisteredUsers> allManager = businessManDAO.getAllManagers();
		model.addAttribute("allManagers", allManager);
		return "businessMan/deleteManagerForm";
	}
	
	@RequestMapping(value="/deleteManager")
	public String deleteUser(@RequestParam("allManagers") String[] allManagers,
							 HttpServletRequest request,
							 Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		int noOfOperators = allManagers.length;
		if(noOfOperators<1){
			model.addAttribute("msg", "Select atleast one manager to delete.");
			return "businessMan/deleteManagerForm";
		}
		System.out.println(noOfOperators);
		for(int i=0;i<noOfOperators;i++){
			System.out.println(allManagers[i]);
			businessManDAO.deleteManager(allManagers[i]);
		}
		model.addAttribute("allManagers", allManagers);
		return "businessMan/deleteManager";
	}
	
	@RequestMapping(value="/RevenueOptions")
	public String calcRevenue(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}		
		return "businessMan/RevenueOptions";
	}
	
	@RequestMapping(value="/RevenueResult")
	public String displayRevenue(@RequestParam("RevenueOptions") String revenueOption,
								 HttpServletRequest request,
								 Model model){
		HttpSession session = request.getSession(false);
		if(session ==null){
			model.addAttribute("msg", "Login to access this resource.");
			return "home";
		}
		int bill=0;
		if(revenueOption.equals("revenueOfPremiumCustomer")){
			 bill=businessManDAO.getBillAmount();
			System.out.println(bill);
		}else if(revenueOption.equals("revenueOfGuests")){
			 bill=businessManDAO.getBillAmountOfGuest();
				System.out.println(bill);
		}else if(revenueOption.equals("revenueOfTwoWheeler")){
			bill=businessManDAO.getBillAmountOfGuestTwo();
			System.out.println(bill);
			
		}else if(revenueOption.equals("revenueOfFourWheeler")){
			bill=businessManDAO.getBillAmountOfGuestCar();
			System.out.println(bill);
			
		}else if(revenueOption.equals("totalRevenue")){
			int bill1=businessManDAO.getBillAmount();
		int	bill2=businessManDAO.getBillAmountOfGuest();
		bill=bill1+bill2;
			System.out.println(bill);
			
		}

		else if(revenueOption.equals("revenueOnYearlyBasis")){
			int bill1=businessManDAO.getBillAmountYear();
		int	bill2=businessManDAO.getBillAmountOfGuestYear();
		bill=bill1+bill2;
			System.out.println(bill);
			
		}
		else if(revenueOption.equals("totalRevenue")){
			int bill1=businessManDAO.getBillAmount();
			int	bill2=businessManDAO.getBillAmountOfGuest();
			bill=bill1+bill2;
			System.out.println(bill);
}
		
		model.addAttribute("bill", bill);
		return "businessMan/RevenueResult";
	}
	
	
}



