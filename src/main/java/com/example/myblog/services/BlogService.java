package com.example.myblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.myblog.models.Blog;
import com.example.myblog.repositories.BlogRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository repository;
	
	public boolean validateBlog(String title,String content) {
		Blog blog=repository.findByTitle(title);
		if(blog==null) {
			return false;
		}else {
			return true;
		}
	}
	public boolean createBlog(String title,String content) {
		if(repository.findByTitle(title)==null){
			repository.save(new Blog(title,content));
			return true;
		}else {
		return false;
		}
	}



	

}
