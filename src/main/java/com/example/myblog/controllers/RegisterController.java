package com.example.myblog.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import ONeW.Spring.services.AccountService;

@Controller
public class RegisterController {

	@Autowired
	AccountService accountService;
	
	
	
	@GetMapping("/register")
	public String GetRegisterPage() {
		return "Register.html";
	}

	@PostMapping("/register")
	public ModelAndView register(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
      
		if (accountService.createAccount(username, password)) {
			mav.addObject("erreo", false);
			mav.setViewName("Login1.html");
			
		} else {
			mav.addObject("erreo", true);
			mav.setViewName("Register.html");
			

		}
		return mav;
	}

}
