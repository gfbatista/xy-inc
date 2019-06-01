package com.luizalabs.desafioapi.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Erro> erros = listaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> listaErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<>();

		for (FieldError fildError : bindingResult.getFieldErrors()) {
			String mensagemValidacao = messageSource.getMessage(fildError, LocaleContextHolder.getLocale());
			erros.add(new Erro(mensagemValidacao));
		}

		return erros;
	}

	public static class Erro {
		private String mensagemValidacao;

		public Erro(String mensagemValidacao) {
			this.mensagemValidacao = mensagemValidacao;
		}

		public String getMensagemValidacao() {
			return mensagemValidacao;
		}
	}
}
