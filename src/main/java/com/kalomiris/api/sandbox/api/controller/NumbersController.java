package com.kalomiris.api.sandbox.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kalomiris.api.sandbox.api.resource.SingleNumberResource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/numbers", produces = "application/json")
public class NumbersController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<SingleNumberResource> getRandomNumber() {
		double randomNumber = Math.random();
		return new ResponseEntity<>(new SingleNumberResource(randomNumber), HttpStatus.OK);
	}
}
