package com.bhavna.myException;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		return new ResponseEntity<String>("the entered Id is not present in DB please enter correct Id...", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
		return new ResponseEntity<String>("the entered details are not present in DB please check the details...", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException) {
		return new ResponseEntity<String>("please enter the all details...", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ErrorMsg.class)
	public ResponseEntity<String> handleEmptyException(ErrorMsg emptyException) {
		return new ResponseEntity<String>("quantity should be 1 or more...", HttpStatus.BAD_REQUEST);
	}
}
