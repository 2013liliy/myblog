package com.example.myblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myblog.models.Account;
import com.example.myblog.models.Blog;
import com.example.myblog.repositories.BlogRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository repository;

	public boolean createBlog(String title, String content) {
		
		if (BlogRepository.findByTitle(title) == null) {
			repository.save(new Blog(title, content));
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateAccount(String title, String content) {
		Blog blog = BlogRepository.findByTitle(title);
		if (blog== null) {
			return false;
		} else {
			return true;
		}

	}
	

}
