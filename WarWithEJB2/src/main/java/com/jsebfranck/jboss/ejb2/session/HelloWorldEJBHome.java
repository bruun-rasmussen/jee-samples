package com.jsebfranck.jboss.ejb2.session;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface HelloWorldEJBHome extends EJBHome {
	public HelloWorldEJB create() throws RemoteException, CreateException;
}
