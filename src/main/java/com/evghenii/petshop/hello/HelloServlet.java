package com.eventim.petshop.hello;

import com.eventim.petshop.view.FirstPage;



import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*@WebServlet(urlPatterns = "/hello")
*//*@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(errorPage = "/error.html",
                loginPage = "/welcome.html"))*//*
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user", "admin" },
        transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL))
@Stateful*/
public class HelloServlet extends HttpServlet {

/*   @Inject
    private SecurityContext securityContext;

    @Override
    public void init() throws ServletException {
        super.init();
    }*/

    @Override
    public void service(ServletRequest req, ServletResponse res) {

    }
 /*   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (securityContext.isCallerInRole("admin")) {
            response.sendRedirect("/admin.jsf");
        } else if  (securityContext.isCallerInRole("user")) {
            response.sendRedirect("/overview.jsf");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }*/

}
