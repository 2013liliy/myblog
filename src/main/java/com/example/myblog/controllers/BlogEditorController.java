package com.example.myblog.controllers;

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

	@GetMapping("/blogEditor")
	public String GetblogEditor() {
		return "blogEditor.html";
	}

	@PostMapping("/blogEditor")
	public ModelAndView login(@RequestParam String title, @RequestParam String content, ModelAndView mav) {
		
		if (blogService.createBlog(title, content)) {
			mav.addObject("name", title);
			mav.setViewName("blogPicture");
		} else {
			mav.setViewName("blogEditor");

		}
		return mav;
	}
//	@RequestMapping("/blogPicture")
//	public String blog(Model model) {
//		Blog blog=BlogRepository.findByTitle("");
//		if(blog==null) {
//			System.out.println("");
//		}else
//			model.addAttribute("bolg",blog);
//		return "blogPicture";
//	}
	
}
