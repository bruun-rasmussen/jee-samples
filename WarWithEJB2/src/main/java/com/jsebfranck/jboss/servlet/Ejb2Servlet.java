package com.jsebfranck.jboss.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsebfranck.jboss.ejb2.entity.Member;
import com.jsebfranck.jboss.ejb2.entity.MemberHome;
import com.jsebfranck.jboss.ejb2.session.HelloWorldEJB;
import com.jsebfranck.jboss.ejb2.session.HelloWorldEJBHome;

@WebServlet("/Ejb2Servlet")
public class Ejb2Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      // EJB 2 session
      HelloWorldEJBHome helloWorldEJBHome = (HelloWorldEJBHome) new InitialContext().lookup("java:global/WarWithEJB2/HelloWorldEJB!com.jsebfranck.jboss.ejb2.session.HelloWorldEJBHome");
      HelloWorldEJB helloWorldEjb = helloWorldEJBHome.create();
      response.getWriter().println("EJB session test : " + helloWorldEjb.helloWorld());

      // EJB 2 entity
      MemberHome memberHome = (MemberHome) new InitialContext().lookup("java:global/WarWithEJB2/MemberEJB!com.jsebfranck.jboss.ejb2.entity.MemberHome");
      Member member = memberHome.create(100L, "jsebfranck");
      response.getWriter().println("EJB entity test : " + member.getId() + " - " + member.getLogin());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
