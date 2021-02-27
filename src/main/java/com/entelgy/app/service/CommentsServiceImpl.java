package com.entelgy.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.app.models.Comments;
import com.entelgy.app.models.CommentsResponse;
import com.entelgy.app.models.Response;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private RestTemplate clienteRestTemplate;

	@Override
	public Response listar() {
		List<Comments> comments = Arrays.asList(
				clienteRestTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comments[].class));

		List<CommentsResponse> listComments = new ArrayList<CommentsResponse>();
		
		Response response = new Response();

		for (Comments com : comments) {
			CommentsResponse mod = new CommentsResponse();
			mod.setPostId(com.getPostId());
			mod.setId(com.getId());
			mod.setEmail(com.getEmail());
			listComments.add(mod);
		}
		
		response.setData(listComments);
		
		return response;
	}

}
