package com.br.itidigital.service.impl;

import org.springframework.stereotype.Service;

import com.br.itidigital.controller.request.Payload;
import com.br.itidigital.exception.BadRequestException;
import com.br.itidigital.service.ValidateService;


@Service
public class ValidateServiceImpl implements ValidateService{

	@Override
	public Boolean test(Payload payload) {
		
		if(isNull(payload.getPassword())) {
			throw new BadRequestException("Campo password obrigatório!");
		}
		
		String password = payload.getPassword();
		return password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*\\-+()])(?:(.)(?!.*\\1)){8,}$") && password.matches("^\\S+$");
	}
	
	private boolean isNull(String s) {
		return s == null;
	}

}
