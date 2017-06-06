package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeControler {
	
	@RequestMapping(value={"/","/home"})
	public String homePage(){
		return "home";
	}
	
	@RequestMapping(value="/login")
	public String loginRedirect(@RequestParam("role") String role){
		if(role.equalsIgnoreCase("OPERATOR")){
			return "forward:/operator/login";
		}
		else if(role.equalsIgnoreCase("MANAGER")){
			return "forward:/manager/login";
		}
		else if(role.equalsIgnoreCase("BUSINESSMAN")){
			return "forward:/businessMan/login";
		}
		else{
			return "";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
	    return "redirect:/home";
	}
}
