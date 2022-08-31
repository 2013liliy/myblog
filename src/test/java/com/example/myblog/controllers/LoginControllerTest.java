package com.example.myblog.controllers;

import static org.mockito.ArgumentMatchers.any;
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
public class LoginControllerTest {
	@MockBean
	private AccountService accountService;
	@MockBean
	private BlogService blogService;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void prepareData() {
		when(accountService.validateAccount(any(), any())).thenReturn(false);
		when(accountService.validateAccount("Alice", "ABC12345")).thenReturn(true);
		when(blogService.findByUsername("Alice")).thenReturn(List.of(new Blog("qq","vv","Alice")));
	}
	
	
	@Test
	public void testGetLoginPage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/login");
		
		mockMvc.perform(request)
				.andExpect(view().name("login.html"))
				.andExpect(model().attributeDoesNotExist("error"));
	}
	
	@Test
	public void testLogin_CorrectInfo_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.post("/login")
				.param("username", "Alice")
				.param("password", "ABC12345");
		
		mockMvc.perform(request)
				.andExpect(view().name("myBlog"))
				.andExpect(model().attribute("name", "Alice"))
		        .andExpect(model().attribute("error", false))
		        .andExpect(model().attribute("blogs",List.of(new Blog("qq","vv","Alice"))));
		        
	}
	
	@Test
	public void testLogin_IncorrectInfo_Fail() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.post("/login")
				.param("username", "Bob")
				.param("password", "Bob54321");
		
		mockMvc.perform(request)
				.andExpect(view().name("login"))
				.andExpect(model().attribute("error", true));
	}
	

}
