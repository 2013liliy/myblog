package com.example.myblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.myblog.services.AccountService;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;
	
//	@GetMapping("/login")
//	public String index() {
//		return "login.html";
//	}
	
	@GetMapping("/login")
	public String GetLoginPage() {
		return "login.html";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
		if (accountService.validateAccount(username, password)) {
			mav.addObject("name", username);
			mav.addObject("error", false);
			mav.setViewName("myBlog");
		} else {
			mav.addObject("error", true);
			mav.setViewName("login");

		}
		return mav;
	}

}
