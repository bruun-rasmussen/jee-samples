package com.jsebfranck.jboss.ejb2.session;

import com.jsebfranck.jboss.ejb2.entity.Member;
import com.jsebfranck.jboss.ejb2.entity.MemberHome;
import java.rmi.RemoteException;
import java.util.logging.Logger;
import javax.ejb.CreateException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloWorldEJBBean implements SessionBean {

    private static final Logger LOG = Logger.getLogger(HelloWorldEJBBean.class.getSimpleName());
    private static final long serialVersionUID = 1L;

    public String helloWorld() throws RemoteException {
        return "Hello world, I am an EJB2 session";
    }

    public Long addMember(Long id, String login) throws CreateException {
        // EJB 2 entity
        Member member = memberHome().create(id, login);
        LOG.info("EJB entity test : " + member.getId() + " - " + member.getLogin());
        return member.getId();
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

    private static MemberHome memberHome() {
        try {
            return (MemberHome)new InitialContext().lookup("java:module/MemberEJB!com.jsebfranck.jboss.ejb2.entity.MemberHome");
        }
        catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
