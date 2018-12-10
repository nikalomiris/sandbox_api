package com.kalomiris.api.sandbox.api.repository;

import org.springframework.stereotype.Repository;

import com.kalomiris.api.sandbox.api.domain.SingleNumber;

@Repository
public class SingleNumberRepository extends InMemoryRepository<SingleNumber> {

	protected void updateIfExists(SingleNumber original, SingleNumber updated) {
		original.setValue(updated.getValue());
	}
}
