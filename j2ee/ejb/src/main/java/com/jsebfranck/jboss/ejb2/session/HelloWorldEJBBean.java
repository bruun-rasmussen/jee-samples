package com.jsebfranck.jboss.ejb2.session;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloWorldEJBBean implements SessionBean {
	private static final long serialVersionUID = 1L;

	public String helloWorld() throws RemoteException {
		return "Hello world, I am an EJB2 session";
	}
	
	public void ejbActivate() throws EJBException, RemoteException {
	}

	public void ejbPassivate() throws EJBException, RemoteException {
	}

	public void ejbRemove() throws EJBException, RemoteException {
	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
	}
}
