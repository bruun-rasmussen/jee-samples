package com.jsebfranck.jboss.ejb2.entity;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface MemberHome extends EJBLocalHome {
    public Member create(Long id, String login) throws CreateException;

    public Member findByPrimaryKey(Long id) throws FinderException;

    public Collection findAll() throws FinderException;
}