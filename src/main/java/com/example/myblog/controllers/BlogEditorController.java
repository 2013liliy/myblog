package com.example.myblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.myblog.models.Blog;
import com.example.myblog.repositories.BlogRepository;
import com.example.myblog.services.BlogService;

@Controller
public class BlogEditorController {

	@Autowired
	private BlogService blogService;

	@GetMapping("/blogPicture")
	public String GetblogPicture() {
		return "blogPicture.html";
	}

	@PostMapping("/blogEditor")
	public ModelAndView GetblogEditor(@RequestParam String username, ModelAndView mav) {
		mav.addObject("username", username);
		mav.setViewName("blogEditor");
		return mav;
	}

	@PostMapping("/addBlog")
	public ModelAndView addBlog(@RequestParam String title, @RequestParam String content, @RequestParam String username,
			ModelAndView mav) {
		blogService.createBlog(title, content, username);
		// 根据登录名字找到blogs *使用方法
		List<Blog> blogs = blogService.findByUsername(username);
		mav.addObject("blogs", blogs);

		mav.addObject("name", username);
		mav.setViewName("myBlog");

		return mav;
	}
}
