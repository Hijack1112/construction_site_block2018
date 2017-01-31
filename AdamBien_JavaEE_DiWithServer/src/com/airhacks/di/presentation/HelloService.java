package com.airhacks.di.presentation;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.interceptor.Interceptors;

/**
 * This is an EJB, note that this EJB is only called once with PostConstruct,
 * but onDestroy never called, in contrary to Index which is request Scoped and
 * therefore everytime you refresh the page the index is created and then
 * destroyed --> Different Lifecycle obviously
 */

// Stateless means there is no association between the EJB Instance and the Invoker, the Caller 
// Stateful means that the Invoker, the user, of the helloService EJB, would get a dedicated instance of the EJB. In our case this means there will be one EJB instance per Index.java Object. HelloService will be associated with Index
// you could mix @Stateful with @SessionScoped, the state will be cached during the session and the destroyed. As a consequence you must also the implement the serializable interface. Default is stateless

/**
 * @Singleton is also possible (if its alone its the same as applicationScoped). It is a stateless EJB with only 1 Instance per JVM, no cluster wide singleton. Especially in combination with @Startup. A singleton is a bottleneck. Only 1 Thread access the Instance.
 * @DependsOn("FireStarter") means that HelloService will wait for FireStarter to start and then will start itself! We changed the start order!
 * @ConcurrencyManagement(ConcurrencyManagementType.BEAN) means it frees the lock on the instance, so that many threads can access the instance
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("FireStarter")
@Startup
@Singleton
@Interceptors(MethodCallLogger.class)
public class HelloService {

	@Resource
	SessionContext sc;
	
	@PostConstruct
	private void onInit() {
		System.out.println("Creating HelloService(EJB)");
	}

	public String sayHello() {
		return "hi there! " + new Date() + " " + sc.getCallerPrincipal();
	}

	@PreDestroy
	public void onDestroy() {
		System.out.println("Destroying EJB");
	}

}
