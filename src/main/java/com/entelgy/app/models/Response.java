package com.entelgy.app.models;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

	private List<CommentsResponse> data;

	public List<CommentsResponse> getData() {
		return data;
	}

	public void setData(List<CommentsResponse> data) {
		this.data = data;
	}

	private static final long serialVersionUID = -7269563029180759476L;
}
