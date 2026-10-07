package com.business;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class Exceptions {

	private static final Logger log = LoggerFactory.getLogger(Exceptions.class);

	// Missing records -> 404, not a generic 500
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NoSuchElementException.class, IllegalArgumentException.class })
	public String notFound() {
		return "exception";
	}

	// Everything else -> 500, logged with the stack trace
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ModelAndView handler(Exception ex) {
		log.error("Unhandled exception", ex);
		return new ModelAndView("exception");
	}
}
