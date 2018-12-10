package com.kalomiris.api.sandbox.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kalomiris.api.sandbox.api.domain.SingleNumber;
import com.kalomiris.api.sandbox.api.repository.SingleNumberRepository;
import com.kalomiris.api.sandbox.api.resource.SingleNumberResource;
import com.kalomiris.api.sandbox.api.resource.SingleNumberResourceAssembler;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/numbers", produces = "application/json")
public class NumbersController {
	
	@Autowired
	private SingleNumberRepository repository;
	
	@Autowired
	private SingleNumberResourceAssembler assembler;
	
	@RequestMapping(value = "/getRandom", method = RequestMethod.GET)
	public ResponseEntity<SingleNumberResource> getRandomNumber() {
		SingleNumber randomNumber = repository.create(new SingleNumber(Math.random()));
		return new ResponseEntity<>(assembler.toResource(randomNumber), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRandomUpTo/{max}", method = RequestMethod.GET)
	public ResponseEntity<SingleNumberResource> getRandomNumberUpTo(@PathVariable Double max) {
		SingleNumber randomNumber = repository.create(new SingleNumber(Math.random()*(max+1)));
		return new ResponseEntity<>(assembler.toResource(randomNumber), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRandomInRange/{min}/{max}", method = RequestMethod.GET)
	public ResponseEntity<SingleNumberResource> getRandomNumberUpTo(@PathVariable Double min, @PathVariable Double max) {
		SingleNumber randomNumber = repository.create(new SingleNumber(Math.random()*((max - min) + 1) + min));
		return new ResponseEntity<>(assembler.toResource(randomNumber), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getHistory" , method = RequestMethod.GET)
	public ResponseEntity<Collection<SingleNumberResource>> getHistory() {
		List<SingleNumber> numbers = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(numbers), HttpStatus.OK);
	}
}
