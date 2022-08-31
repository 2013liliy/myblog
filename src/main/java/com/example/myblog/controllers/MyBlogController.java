package com.example.myblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.myblog.models.Blog;
import com.example.myblog.services.BlogService;

@Controller
public class MyBlogController {

	@Autowired
	private BlogService blogService;

	// @GetMapping("/myBlog")
	// public ModelAndView getMyBlog(ModelAndView mav) {
	// myBlog显示已有内容
	// List<Blog>blogs=blogService.findAll();
	// mav.addObject("blogs", blogs);
	// mav.setViewName("myblog");

	// 删除博客内容*使用方法

	@PostMapping("/deleteMyBlog")
	public ModelAndView deleteBlog(@RequestParam Long id, ModelAndView mav) {
		blogService.deleteById(id);
		mav.setViewName("myblog");

		// 修改博客内容*使用方法
		// List<Blog> blogs1 = blogService.updataBlog();
		// mav.addObject("blogs", blogs1);
		// mav.setViewName("myblog");

		return mav;
	}
}
