package com.youtube.jwt.entity;

public class RegistrationResponse {
	String response;


	public RegistrationResponse(String response) {	
		this.response = response;
	
	}


	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}


	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
}
