package com.airhacks.di.presentation;

import java.lang.reflect.Constructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.validation.constraints.Size;

/**
 * @Model is from Java EE, alternative own class @Presenter: The Index survives
 *        only 1 Request and is going to be visible in JSF
 *
 */
// @Model
@Presenter
public class Index {

	// this is called Field Injection

	// @Inject vs. @EJB vs. @Resource

	// @EJB when you look at the annotation itself, it is more configurable, but
	// convention over configuration is the rule, so @Inject is perfectly fine.
	// the helloService is actually an EJB, so you could use @EJB instead
	// @Inject it won't matter.
	// @Inject For 99% of the cases, always use @Inject instead of @EJB.
	// @Resoure is part of JDK (not JavaEE). You could inject everything what is
	// stored in der JNDI Tree from the ApplicationServer. Good Examples are
	// Topics, Queues (JMS), Datasources, EntityManagerFactory

	@Inject
	private HelloService helloService;

	// @Inject not neccessary because UserCounter is injected using the method
	// injection
	private UserCounter userCounter;

	// @Inject not neccessary because GlobalCounter is injected using the
	// construtor
	private GlobalCounter globalCounter;

	@Inject
	private EmptyDelegate emptyDelegate;

	@Inject
	private NakedObject nakedObject;

	@Inject
	private BigBrother bigBrother;

	@Size(min=2, max = 10, message = "Don't do that!")
	private String text;

	@PostConstruct
	private void onInit() {
		System.out.println("Creating Index");
	}

	// this is called Method Injection, is not really neccessary @Inject is
	// always ok
	@Inject
	public void setUserCounter(UserCounter userCounter) {
		this.userCounter = userCounter;
	}

	// this is called Constructor Injection
	@Inject
	public Index(GlobalCounter globalCounter) {
		this.globalCounter = globalCounter;
	}

	// Default Constructor is mandatory for the Application Server
	public Index() {
	}

	// txProxy.begin
	public String getMessage() {
		userCounter.increase();
		globalCounter.increase();
		nakedObject.hello();
		String sayHello = helloService.sayHello();
		bigBrother.gatherEverything(sayHello);
		return sayHello;
	}
	// txProxy.commit

	public int getUserCounter() {
		return this.emptyDelegate.getUserCounter();
	}

	public int getGlobalCounter() {
		return this.emptyDelegate.getGlobalCounter();
	}

	public Object save() {
		// if we return here the string of a page, the application would
		// navigate to this page
		this.bigBrother.gatherEverything(this.text);
		// return null;
		return "theend";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@PreDestroy
	public void onDestroy() {
		System.out.println("Destroying Index");
	}

}
