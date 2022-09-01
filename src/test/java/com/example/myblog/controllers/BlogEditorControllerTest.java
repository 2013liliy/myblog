package com.example.myblog.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.myblog.models.Blog;
import com.example.myblog.services.AccountService;
import com.example.myblog.services.BlogService;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogEditorControllerTest {
	@MockBean
	private BlogService blogService;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void prepareData() {
		doNothing().when(blogService).createBlog(any(String.class), any(String.class), any(String.class));
	    when(blogService.findByUsername("Alice")).thenReturn(List.of(new Blog("qq", "vv", "Alice")));
	}

	@Test
	public void testBlogPicturePage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/blogPicture");

		mockMvc.perform(request).andExpect(view().name("blogPicture.html"))
				.andExpect(model().attributeDoesNotExist("error"));
	}

	@Test
	public void testBlogEditorPage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/blogEditor").param("username", "Alice");

		mockMvc.perform(request).andExpect(view().name("blogEditor")).andExpect(model().attribute("username", "Alice"))
				.andExpect(model().attributeDoesNotExist("error"));
	}

	@Test
	public void testAddBlog_CorrectInfo_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/addBlog").param("title", "hello")
				.param("content", "frfrfr").param("username", "Alice");

		mockMvc.perform(request).andExpect(view().name("myBlog")).andExpect(model().attribute("name", "Alice"))
				.andExpect(model().attribute("blogs", List.of(new Blog("qq", "vv", "Alice"))))
				.andExpect(model().attributeDoesNotExist("error"));
	}

}
