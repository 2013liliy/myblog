package com.example.myblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myblog.models.Blog;
import com.example.myblog.repositories.BlogRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository repository;

	public void createBlog(String title, String content, String username) {

		repository.save(new Blog(title, content, username));
	}
	
	public void editBlog(String title, String content,Long id) {
     
		Blog blog=repository.findById(id).get();
		blog.setTitle(title);
		blog.setContent(content);
		repository.save(blog);
	}

	public List<Blog> findAll() {
		return repository.findAll();
	}

	// 根据username查找博客*声明方法
	public List<Blog> findByUsername(String username) {

		return repository.findByUsername(username);
	}

	// 删除博客内容*声明方法
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Blog findById(Long id) {
		return repository.findById(id).get();
	}
	
   //编辑博客
	public void editById(Long id) {
		repository.editById(id);
		
	}

	public void UpDateBlogById(Long id, String title, String content) {
		
		
	}

	
		
		
	

	// 修改博客内容*声明方法
	// public List<Blog> updataBlog() {

	// return updataBlog();
	// }


}