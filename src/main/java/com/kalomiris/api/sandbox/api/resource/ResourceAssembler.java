package com.kalomiris.api.sandbox.api.resource;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<DomainType, ResourceType> {
	
	public abstract ResourceType toResource(DomainType domainType);
	
	public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {
		return domainObjects.stream().map(o -> toResource(o)).collect(Collectors.toList());
	}
}
