package com.example.myblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.myblog.models.Account;
import com.example.myblog.models.Blog;
import com.example.myblog.services.BlogService;
import com.example.myblog.repositories.BlogRepository;


@Controller
public class BlogEditorController {
	
	@Autowired
	
	private BlogService BlogService;
	
	@GetMapping("/blogPicture")
	public String GetblogPicture() {
		return "blogPicture.html";
	}
	@GetMapping("/blogEditor")
	public String GetblogEditor() {
		return "blogEditor.html";
	}
	public boolean createBlog(String title, String content) {
		if(repository.findByTitle(title)==null){
			repository.save(new Blog(title,content));
			return true;
		}else {
		return false;
		}

	}


	
	

}
