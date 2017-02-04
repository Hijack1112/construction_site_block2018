package myOwnAnnotation;

import myOwnAnnotation.MyInject.DayTime;



/** 08 Proxies and Decorators
 *  The Application Server uses DI for one purpose - Interception.
 *  If you Debug, not Service is injected more like eg. $Proxy300 = Dynamic Proxys which implements the interfaces BUT not the service IMPL!
 *  The Application Server provides "added Value", it injects cross-cutting concerns on e.g EJB = Transactions, Security, Threading, State Management, Monitoring.
 *  This means you don't know which one of these EJB starts - this all is implemented by Proxys. 
 */
public class Facade {
	
	//DayTime.Morning is a Payload on the Annotation which we read on the runtime
	@MyInject(value = DayTime.MORNING)
	private Service service;
	
	String somethingElse;
	
	public void invokeService () {
		service.serve();
	}

	@Override
	public String toString() {
		return "Facade [service=" + service + ", somethingElse=" + somethingElse + "]";
	}
	
	
	
}
