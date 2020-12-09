package com.br.itidigital.controller.response;

import com.br.itidigital.controller.response.interfaces.Builder;

public class ResponseBuilder implements Builder<ResponseBuilder> {
	
	private Boolean valid;

	@Override
	public ResponseBuilder setValid(Boolean valid) {
		this.valid = valid;
		return this;
	}
	
	public Response build() {
		return new Response(this.valid);
	}

}
