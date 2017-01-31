package com.airhacks.di.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.ScheduleExpression;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
// @Stateless
public class BigBrother {

	/**
	 * Look at import javax.ejb.Asynchronous; --> it works only with EJB,
	 * therefore we make the class @Stateless (== EJB), and the Application is
	 * as fast as without threadsleep
	 */
	// @Asynchronous
	// public void gatherEverything(String message) {
	// System.out.println("Save it for later: " + message);
	// try {
	// // Just for demonstration to lock the thread - bad practice, never
	// // do this. Is actually a placeholder for expensive operation
	// Thread.sleep(3000);
	// } catch (InterruptedException e) {
	// Logger.getLogger(BigBrother.class.getName()).log(Level.SEVERE, null, e);
	// }
	// }

	private CopyOnWriteArrayList<String> messageQueue;

	// @Resource because its part of the ApplicationServer
	@Resource
	private TimerService ts;

	private Timer timer;

	@Inject
	MessageAnalyzer ma;

	@Inject
	MessageArchiver archiver;

	@Inject
	Event<String> events;

	@Resource
	SessionContext sc;
	
	private String test;

	@PostConstruct
	private void initialize() {
		this.messageQueue = new CopyOnWriteArrayList<>();
		ScheduleExpression scheduleExpression = new ScheduleExpression();
		scheduleExpression.minute("*").hour("*").second("*/5");

		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setPersistent(false);

		timer = ts.createCalendarTimer(scheduleExpression, timerConfig);
	}

	//txProxy.begin
	public void gatherEverything(String message) {
		this.archiver.save(message);
		this.messageQueue.add(message);
		this.events.fire(message);
		
//		this.sc.setRollbackOnly();
	}
	//txProxy.commit

	/**
	 * Works fine
	 */
	// @Schedule(second = "*/2", minute = "*", hour = "*", persistent = false)
	// public void batchAnalyze() {
	// System.out.println("Analyzing at: " + new Date());
	// for (String message: messageQueue) {
	// System.out.println("-- " + message);
	// this.messageQueue.remove(message);
	// }
	// }

	/**
	 * Alternative!
	 */
	@Timeout
	public void batchAnalyze() {
		System.out.println("Analyzing at: " + new Date());
		List<Future<Boolean>> results = new ArrayList<>();
		for (String message : messageQueue) {
			// System.out.println("-- " + message);
			results.add(ma.analyze(message));
			this.messageQueue.remove(message);
		}

		for (Future<Boolean> result : results) {
			try {
				System.out.println("### Result is: " + result.get());
			} catch (InterruptedException | ExecutionException e) {
				Logger.getLogger(BigBrother.class.getName()).log(Level.SEVERE, null, e);
			}

		}
	}

}
