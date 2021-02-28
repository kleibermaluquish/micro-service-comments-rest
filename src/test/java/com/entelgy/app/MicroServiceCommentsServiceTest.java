package com.entelgy.app;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.entelgy.app.models.Comments;
import com.entelgy.app.service.CommentsService;
import com.entelgy.app.service.CommentsServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class MicroServiceCommentsServiceTest {

	@MockBean
	RestTemplate clienteRestTemplate;
	CommentsService  commentsService;
	
	@BeforeAll
	public void setUp() {
		clienteRestTemplate = Mockito.mock(RestTemplate.class);
		commentsService = new CommentsServiceImpl(clienteRestTemplate); 
	}
	
	@Test	
	public void serviceTest() {
		Mockito.when(clienteRestTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comments[].class)).thenReturn(getComments());
		assertNotEquals(null, commentsService.listar());
	}
	
	
	public Comments[] getComments(){
		Comments[] comments = new Comments[1];
		Comments comment = new Comments();
		comment.setBody("laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");
		comment.setEmail("Eliseo@gardner.biz");
		comment.setId(1);
		comment.setName("id labore ex et quam laborum");
		comment.setPostId(2);
		comments[0]=comment;
		return comments;
	}
		
}