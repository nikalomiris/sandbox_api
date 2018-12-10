package com.kalomiris.api.sandbox.api.domain;

public class SingleNumber implements Identifiable {
	
	private Long id;
	private double value;
	
	public SingleNumber(double value) {
		this.value = value;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
