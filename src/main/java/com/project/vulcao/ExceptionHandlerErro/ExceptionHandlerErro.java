package com.project.vulcao.ExceptionHandlerErro;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.project.vulcao.Exceptions.ObjectValueEqualMessageError;

@RestControllerAdvice
public class ExceptionHandlerErro {
   
	@ExceptionHandler(ObjectValueEqualMessageError.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErroResponse NotValueData(ObjectValueEqualMessageError ex, WebRequest request) {
		ErroResponse ErroReturn = new ErroResponse(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
				
		return ErroReturn;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErroResponse erroResponse (Exception ex, WebRequest request) {
		ErroResponse erroNative = new ErroResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return erroNative;
	}
	
}










