package myOwnAnnotation;

import java.lang.reflect.Proxy;

public class Decorator {

	
	/**
	 * 09 07:00 Dynamic Proxys are basically AOP (use generic methods over many classes - cross-cutting concern) builtIn in JDK.
	 * 
	 * Only Problem is you can only decorate Interface, so the Application Server are manipulating byte code to generate temporary Interfaces on-the-fly and use Dynamic Proxys.
	 * or
	 * To decorate the classes on-the-fly using own Frameworks or Utilities.
	 * 
	 * 
	 * @param toDecorate
	 * @return
	 */
	public static Object decorate(Object toDecorate) {
		Class<? extends Object> clazz = toDecorate.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new LoggingAspect(toDecorate));
	}
}
