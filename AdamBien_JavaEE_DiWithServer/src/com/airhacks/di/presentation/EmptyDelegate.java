package com.airhacks.di.presentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmptyDelegate {
	
	@Inject
	private GlobalCounter globalCounter;
	
	@Inject
	private UserCounter userCounter;
	

	public int getGlobalCounter() {
		return globalCounter.getCounter();
	}
	
	public int getUserCounter() {
		return userCounter.getCounter();
	}
	
}
