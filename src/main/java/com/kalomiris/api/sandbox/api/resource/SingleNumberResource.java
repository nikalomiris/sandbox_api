package com.kalomiris.api.sandbox.api.resource;

import org.springframework.hateoas.ResourceSupport;

public class SingleNumberResource extends ResourceSupport {
	
	private final double value;
	
	public SingleNumberResource(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

}
