package com.example.SpringCrudOperation.Controller;


import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringCrudOperation.Bean.Users;
import com.example.SpringCrudOperation.Service.UserService;
import com.example.SpringCrudOperation.Utils.ApiResponse;


@Controller
public class LoginController {

	 Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	 @Autowired
	 UserService userService;
	 
	 
	@GetMapping("/login")
	public String getLoginPage() {
		logger.info("inside login page---->");
		return "login";
	}
	
//	@PostMapping("/sign-up")
//	public Object userAuthentication(@RequestBody String data, HttpSession session, Model model) {
//		logger.info("Inside user Authentication------>");
//		JSONObject json = new JSONObject(data);
//		 String username = json.getString("username");
//		 String password =  json.getString("password");
//		 logger.info("username=------"+username+ "password----"+password);
//		 
//		 if(null!=username && null!=password) {
//				 Users user = userService.findUserByUsername(username, password);
//				 logger.info("user---"+user);
//				 session.setAttribute("user", user);
//				 model.addAttribute("sucess", "Welcome To HomePage!");
//				 
//				 return "redirect:/home";
//			 }else {
//				 model.addAttribute("error", "Invalid Username and Password!");
//				 return "login";
//			 }
//		 }
	
	 @PostMapping("/sign-up")
	 public @ResponseBody String userAuthentication(@RequestBody String data, HttpSession session, Model model) {
		 logger.info("Inside user Authentication------>");
		 JSONObject json = new JSONObject(data);
		 String username = json.getString("username");
		 String password =  json.getString("password");
		 logger.info("username=------"+username+ "password----"+password);
		 
		 if(null!=username && null!=password) {
				 Users user = userService.findUserByUsername(username, password);
				 logger.info("user---"+user);
				 session.setAttribute("user", user);
			
				 if(user!=null) {
					 logger.info("Inside user is not null-------------");
					 return "success";
				 }else {
					return "error";
				 }
			  }
		 return null;
	 }
	 
	@GetMapping("/home")
	public String getHomePage(HttpSession session) {
		logger.info("Inside home page -----");
		  String user_id = (String) session.getAttribute("username");
		  logger.info("user_id -----"+user_id);
		return "home";
	}
	
}
