package com.br.itidigital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.itidigital.controller.request.Payload;
import com.br.itidigital.controller.response.Response;
import com.br.itidigital.service.ValidateService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class Controller {
	
	private ValidateService validateService;
	
	@Autowired
	public Controller(ValidateService validateService) {
		super();
		this.validateService = validateService;
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição feita com sucesso"),
			@ApiResponse(code = 400, message = "Input não atende ao dominio")})
	@ApiOperation(value = "Validar Senha",
			notes = "Este método valida uma senha de acordo com as regras:\n Nove ou mais caracteres\n Ao menos 1 dígito\n Ao menos 1 letra minúscula\n Ao menos 1 letra maiúscula\n Ao menos 1 caractere especial \n Não possuir caracteres repetidos dentro do conjunto")
	@PostMapping("validate")
	public Response validate(@RequestBody  Payload payload) {
		return Response.builder().
				setValid(validateService.test(payload)).
				build() ;
	}

}
