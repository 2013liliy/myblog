package com.example.myblog.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.myblog.services.BlogService;

@SpringBootTest
@AutoConfigureMockMvc
public class MyBlogControllerTest {
	@MockBean
	private BlogService blogService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testDeleteBlog_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.post("/deleteMyBlog");
		
	}
	
	

}
