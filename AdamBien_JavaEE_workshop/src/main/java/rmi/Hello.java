package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{

	public String hello(String msg) throws RemoteException;  
}
