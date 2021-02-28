package com.entelgy.app.models;

import java.io.Serializable;

public class CommentsResponse implements Serializable {

	private int postId;
	private int id;
	private String email;
	
	public CommentsResponse() {}

	public CommentsResponse(int postId, int id, String email) {
		this.postId = postId;
		this.id = id;
		this.email = email;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private static final long serialVersionUID = -2603411958281672184L;

}
