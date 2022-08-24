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
public class LoginController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/hello")
	public String index() {
		return "hello.html";
	}
	
	@GetMapping("/Login1")
	public String GetLoginPage() {
		return "Login1.html";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, ModelAndView mav) {

		if (accountService.validateAccount(username, password)) {
			mav.addObject("name", username);
			mav.setViewName("Hello.html");
		} else {
			mav.setViewName("Login1.html");

		}
		return mav;
	}

}
