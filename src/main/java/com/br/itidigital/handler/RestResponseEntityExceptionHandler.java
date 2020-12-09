package com.br.itidigital.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.itidigital.exception.BadRequestException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	private final String errorBodyJSON = "{ \"error\": \"%s\" }";
	private final String errorBodyXML = "<error>\"%s\"</error>";

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { BadRequestException.class })
	protected ResponseEntity<Object> handleExceptionMyBadRequest(BadRequestException ex, WebRequest request) {
		return this.handleExceptionInternal(ex, this.createResponseBody(ex, request), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private String createResponseBody(Exception ex, WebRequest request) {
		ex.printStackTrace();

		String responseBody = ex.getMessage() != null ? ex.getMessage() : ex.getClass().getName();
		String accept = request.getHeader(HttpHeaders.ACCEPT);

		if (accept != null && !accept.trim().isEmpty()) {
			if (accept.toLowerCase().contains(MediaType.APPLICATION_JSON_VALUE.toLowerCase()) || accept.toLowerCase().contains(MediaType.APPLICATION_JSON_UTF8_VALUE.toLowerCase())) {
				responseBody = String.format(this.errorBodyJSON, responseBody);
			}
			else if (accept.toLowerCase().contains(MediaType.APPLICATION_XML_VALUE.toLowerCase())) {
				responseBody = String.format(this.errorBodyXML, responseBody);
			}
		}

		return responseBody;
	}

}
