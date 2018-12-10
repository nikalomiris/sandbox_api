package com.kalomiris.api.sandbox.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.kalomiris.api.sandbox.api.domain.SingleNumber;

@Component
public class SingleNumberResourceAssembler extends ResourceAssembler<SingleNumber, SingleNumberResource> {
	
	@Autowired
	protected EntityLinks entityLinks;
	
	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";
	
	@Override
	public SingleNumberResource toResource(SingleNumber number) {
		SingleNumberResource resource = new SingleNumberResource(number.getValue());
		
		final Link selfLink = entityLinks.linkToSingleResource(number);
		
		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));
		
		return resource;
	}
}
