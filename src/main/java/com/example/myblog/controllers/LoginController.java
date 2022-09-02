package com.example.myblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.myblog.models.Blog;
import com.example.myblog.services.AccountService;
import com.example.myblog.services.BlogService;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private BlogService blogService;

	// 打开login页面
	@GetMapping("/login")
	public String GetLoginPage() {
		return "login.html";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
		// 判断是否可以登录
		if (accountService.validateAccount(username, password)) {
			mav.addObject("name", username);
			mav.addObject("error", false);

			// --myBlog显示已有内容
			// List<Blog> blogs = blogService.findAll();
			// mav.addObject("blogs", blogs);
			// mav.setViewName("myblog");

			// 根据登录名字找到blogs *使用方法
			List<Blog> blogs = blogService.findByUsername(username);
			mav.addObject("blogs", blogs);
			System.out.println(blogs);
			mav.setViewName("myBlog");
		} else {
			mav.addObject("error", true);
			mav.setViewName("login");
		}
		return mav;
	}
}
