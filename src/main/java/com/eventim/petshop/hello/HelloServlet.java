package com.eventim.petshop.hello;

import com.eventim.petshop.view.FirstPage;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@Stateful
public class HelloServlet extends HttpServlet {

    @Inject
    private FirstPage firstPage;


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {

    }
}
