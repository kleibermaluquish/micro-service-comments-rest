package com.entelgy.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.entelgy.app.controllers.CommentsController;
import com.entelgy.app.models.Response;

@SpringBootTest(classes={com.entelgy.app.MicroServiceCommentsRestApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MicroServiceCommentsApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private CommentsController controller;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/comments/listar", Response.class))
				.isNotNull();
	}
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(post("/api/comments/listar")).andDo(print()).andExpect(status().isOk());
	}

}
