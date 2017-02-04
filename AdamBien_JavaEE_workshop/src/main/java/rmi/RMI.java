package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Hello hello = (Hello) Naming.lookup("rmi://localhost:1099/hello");
		// The implementation of Hello.getClass is NOT the interface but com.sun.proxy.$Proxy0
		System.out.println("Hello: " + hello.getClass().getName());
		System.out.println(hello.hello("duke"));
	}

}
