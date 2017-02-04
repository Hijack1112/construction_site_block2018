package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Today better and more common: JAX RS
 * 
 * Current implementation of RMI is done through Proxys
 */
public class HelloServant extends UnicastRemoteObject implements Hello{

	private static final long serialVersionUID = 1L;

	public HelloServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String hello(String msg) throws RemoteException {
		return "Hello client " + msg;
	}

}
