package com.eventim.petshop.hello;

import javax.ejb.Stateful;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

@Stateful
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
    }
}
