package com.airhacks.di.presentation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//POJO
public class MessageArchiver {
	
	// at @Inject you cannot configure anything. Go in the Annotation Class and compare it with @PersistenceContext
	@PersistenceContext
	EntityManager em;
	
	public void save(String message) {
		//em.merge == save or update
		em.merge(new Message(message));
	}
}
