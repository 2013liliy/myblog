package com.example.myblog.services;




import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.myblog.models.Blog;
import com.example.myblog.repositories.BlogRepository;

@SpringBootTest
public class BlogServiceTest {
	@MockBean
	private BlogRepository blogRepository;

	@Autowired
	private BlogService blogService;

	@BeforeEach
	public void prepareData() {
		Blog blog = new Blog("hello", "123", "Alice");
		when(blogRepository.save(blog)).thenReturn(blog);
		when(blogRepository.findByTitle("hello")).thenReturn(new Blog("hello", "111", "Alice"));
		when(blogRepository.findByTitle("hi")).thenReturn(null);
		when(blogRepository.findAll()).thenReturn(List.of(new Blog("hi", "999", "Bob")));
	}

	@Test
	public void testCreateBlog_NewTitle_NotNull() {
		blogService.createBlog("hello", "123", "Alice");
		verify(blogRepository, times(1)).save(new Blog("hello", "123", "Alice"));

	}

	

}
