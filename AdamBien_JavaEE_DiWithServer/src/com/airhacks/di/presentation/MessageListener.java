package com.airhacks.di.presentation;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

public class MessageListener {
	
	//called in case of commits
	//@Observes delivers only if the Type matches, and String message matches with event fired in Index.java
	public void onSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) String message){
		System.out.println("+++" + message);
	}
	
	//called in case of a Rollback
	public void onFailure(@Observes(during = TransactionPhase.AFTER_FAILURE) String message){
		System.out.println("---" + message);
	}
}

