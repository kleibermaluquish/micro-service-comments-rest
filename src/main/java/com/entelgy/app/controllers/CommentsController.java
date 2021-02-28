package com.entelgy.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.app.models.Response;
import com.entelgy.app.service.CommentsService;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

	@Autowired
	private CommentsService service;

	public CommentsController(CommentsService service) {
		this.service = service;
	}

	@PostMapping("/listar")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Response> listar() {
		return ResponseEntity.ok(service.listar());
	}
}
