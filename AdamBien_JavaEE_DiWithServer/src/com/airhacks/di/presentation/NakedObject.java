package com.airhacks.di.presentation;

public class NakedObject {

	public void hello() {
		System.out.println("Should not work! But it works because we created beans.xml and changed bean-discovery-mode to 'all'");
	}
	
}
