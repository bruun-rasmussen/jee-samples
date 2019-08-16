package com.jsebfranck.jboss.ejb2.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;

import javax.ejb.EJBObject;

public interface HelloWorldEJB extends EJBObject {
    public String helloWorld() throws RemoteException;
    public Long addMember(Long id, String login) throws CreateException, RemoteException;
}
