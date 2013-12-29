package com.jsebfranck.jboss.ejb2.entity;

import javax.ejb.EJBLocalObject;

public interface Member extends EJBLocalObject {
    public Long getId();
    
    public String getLogin();
}
