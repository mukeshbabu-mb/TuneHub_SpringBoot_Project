package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService; 

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {

		String email = user.getEmail();
		boolean status = userService.emailExists(email);

		if (status == false) {
			userService.addUser(user);
			System.out.println("User added");
		} else {
			System.out.println("User already exists");
		}
		return "home";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, 
			@RequestParam("password") String password) {

		if (userService.validateUser(email, password) == true) {
			
			String role = userService.getRole(email);
			
			if(role.equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else {
			return "login";
		}

	}
}