package com.br.itidigital.controller.request;



public class Payload {
	
	private String password;
	
	public Payload(String password) {
		super();
		this.password = password;
	}
	
	public Payload() {
		super();
	}

	public String getPassword() {
		return this.password;
	}

}
