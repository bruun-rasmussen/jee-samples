package com.jsebfranck.jboss.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsebfranck.jboss.ejb2.session.HelloWorldEJB;
import com.jsebfranck.jboss.ejb2.session.HelloWorldEJBHome;
import java.io.PrintWriter;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;

@WebServlet("/Ejb2Servlet")
public class Ejb2Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Context moduleContext;

    @Override
    public void init() throws ServletException {
        try {
            Properties namingProps = new Properties();
            namingProps.load(Ejb2Servlet.class.getResourceAsStream("/jboss-naming.properties"));
            Object moduleName = namingProps.get("jboss-module-name");
            moduleContext = (Context)new InitialContext().lookup("java:app/" + moduleName);
            log("Loading ejbs from " + moduleContext);
        }
        catch (NamingException ex) {
            throw new ServletException(ex);
        }
        catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            // EJB 2 session
            HelloWorldEJBHome helloWorldEJBHome =
                    (HelloWorldEJBHome)moduleContext.lookup("HelloWorldEJB!com.jsebfranck.jboss.ejb2.session.HelloWorldEJBHome");
            HelloWorldEJB helloWorldEjb = helloWorldEJBHome.create();
            out.println("EJB session test : " + helloWorldEjb.helloWorld());

            // EJB 2 entity
            Long memberId = helloWorldEjb.addMember(100L, "jsebfranck");
            out.println("EJB entity test : " + memberId);
        } catch (Exception ex) {
            out.println("--------");
            ex.printStackTrace(out);
        }
    }
}
