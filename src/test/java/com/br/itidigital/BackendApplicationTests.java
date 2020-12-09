package com.br.itidigital;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.itidigital.controller.request.Payload;
import com.br.itidigital.service.ValidateService;

@SpringBootTest
class BackendApplicationTests {
	
	
	@Autowired
	private ValidateService service;

	@Test
	void contextLoads() {
		assertFalse(service.test(new Payload("")));
		assertFalse(service.test(new Payload("aa"))); 
		assertFalse(service.test(new Payload("ab"))); 
		assertFalse(service.test(new Payload("AAAbbbCc"))); 
		assertFalse(service.test(new Payload("AbTp9!foo"))); 
		assertFalse(service.test(new Payload("AbTp9!foA"))); 
		assertFalse(service.test(new Payload("AbTp9 fok"))); 
		assertTrue(service.test(new Payload("AbTp9!fo"))); 
	}
	
	
	

}
