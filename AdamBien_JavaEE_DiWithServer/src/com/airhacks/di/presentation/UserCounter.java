package com.airhacks.di.presentation;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserCounter extends Counter implements Serializable {

	private static final long serialVersionUID = 1L;
	
}
