package com.flipkart.store.data.main.csvUtils;

public class ResponseMessage {
	private String message;

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
/*
 * The ResponseMessage is for message to client that we’re gonna use in Rest
 * Controller and Exception Handler.
 */