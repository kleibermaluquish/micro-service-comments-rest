package com.entelgy.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.entelgy.app.controllers.CommentsController;
import com.entelgy.app.models.CommentsResponse;
import com.entelgy.app.models.Response;
import com.entelgy.app.service.CommentsService;

@TestInstance(Lifecycle.PER_CLASS)
public class MicroServiceCommentsControllerTest {

	private CommentsController controller;
	private CommentsService service;

	@BeforeAll
	public void setUp() {
		service = Mockito.mock(CommentsService.class);
		controller = new CommentsController(service);
	}

	@Test	
	public void controllerTest() {
		Mockito.when(service.listar()).thenReturn(response());
		ResponseEntity<Response> httpResponse = controller.listar();

		assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
		assertNotEquals(null, httpResponse.getBody());
	}

	public Response response() {
		Response response = new Response();

		List<CommentsResponse> listComments = new ArrayList<CommentsResponse>();

		listComments.add(new CommentsResponse(1, 1, "Eliseo@gardner.biz"));
		response.setData(listComments);

		return response;
	}
}
