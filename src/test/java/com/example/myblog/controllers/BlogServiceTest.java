package com.example.myblog.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.myblog.models.Blog;
import com.example.myblog.repositories.BlogRepository;
import com.example.myblog.services.BlogService;

@SpringBootTest
public class BlogServiceTest {
	@MockBean
	private BlogRepository blogRepository;
	
	@Autowired
	private BlogService blogService;
	
	@BeforeEach
	public void prepareData() {
		Blog blog=new Blog("hello","123","Alice");
		when(blogRepository.save(blog)).thenReturn(blog);
		when(blogRepository.findAll()).thenReturn(List.of(new Blog("hi","999","Bob")));
	}
	
	@Test
	public void testCreateBlog_NewTitle_NotNull() {
		verify(blogService.createBlog("hello","123","Alice"));
	}
	
	@Test
	public void testCreateBlog_Existingtitle_Null() {
		assertNull(blogService.createBlog("hello","123","Alice"));
	}
	@Test
	public void testValidateBlog_CorrectInfo_ReturnTrue() {
		assertTrue(blogService.validateAccount("fff", "dcefd"));
	}
	
	@Test
	public void testValidateBlog_WrongTitle_ReturnFalse() {
		assertFalse(blogService.validateAccount("fcd", "cdcdcdc1"));
	}
	
	@Test
	public void testValidateBlog_WrongContent_ReturnFalse() {
		assertFalse(blogService.validateAccount("fcd", "cdcdcdc1"));
	}
	
	

	

}
