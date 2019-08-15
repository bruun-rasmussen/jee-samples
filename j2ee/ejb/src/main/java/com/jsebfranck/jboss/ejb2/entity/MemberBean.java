package com.jsebfranck.jboss.ejb2.entity;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class MemberBean implements EntityBean {

  private static final long serialVersionUID = 1L;
  private transient EntityContext ctx;

  public MemberBean() {
  }

  public Long ejbCreate(Long id, String login) throws CreateException {
    setId(id);
    setLogin(login);
    return id;
  }

  public void ejbPostCreate(Long id, String login) {
  }

  public abstract Long getId();
  public abstract void setId(Long id);

  public abstract String getLogin();
  public abstract void setLogin(String login);

  public void setEntityContext(EntityContext ctx) {
    this.ctx = ctx;
  }

  public void unsetEntityContext() {
    this.ctx = null;
  }

  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void ejbLoad() {}
  public void ejbStore() {}
  public void ejbRemove() {}
}