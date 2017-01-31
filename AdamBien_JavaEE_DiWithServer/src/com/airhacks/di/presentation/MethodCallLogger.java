package com.airhacks.di.presentation;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MethodCallLogger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object log(InvocationContext invocationContext) throws Exception {
		Method method = invocationContext.getMethod();
		long start = System.nanoTime();
		try {
			System.out.println("Before Method");
			return invocationContext.proceed();
		} finally {
			System.out.println("Method: " + method + " invoked in " + (System.nanoTime() - start) + " seconds");

		}
	}
}
