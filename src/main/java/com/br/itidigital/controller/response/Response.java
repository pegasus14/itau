package com.br.itidigital.controller.response;


public class Response {

	private Boolean valid;
	private static ResponseBuilder builder ;

	public Response(Boolean valid) {
		super();
		this.valid = valid;
		
	}

	public Boolean getValid() {
		return valid;
	}
	
	public static ResponseBuilder builder() {
		if(builder == null) {
			builder = new ResponseBuilder();
		}
		return builder;
	}

	
}
