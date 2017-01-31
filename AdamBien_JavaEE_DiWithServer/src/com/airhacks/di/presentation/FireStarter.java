package com.airhacks.di.presentation;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class FireStarter {
	
	@PostConstruct
	private void onStart() {
		System.out.println("FireStarter is starting.");
	}
}
