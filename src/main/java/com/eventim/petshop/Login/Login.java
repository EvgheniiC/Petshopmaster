package com.eventim.petshop.Login;

import com.eventim.petshop.FacesUtils;
import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.CustomerRepository;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
public class Login implements Serializable {


    @EJB
    private CustomerRepository customerRepository;

    @Size(min = 1, message = "Passwort cannot be empty")
    private String password;
    @Size(min = 1, message = "Login cannot be empty")
    private String login;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password1) {
        this.password = password1;
    }

    public void doLogin(ActionEvent actionEvent) {
        Customer customer;
        try {
            customer = customerRepository.findUserByLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
            return ;
        }
        if (customer!=null && customer.getPassword().equals(this.password)){
        FacesUtils.putUserId(customer.getId());
        redirectToOverview();}
    }

    public void registerNewUser(ActionEvent actionEvent) {
        if (!isCustomerExist()) {
            Customer customer = customerRepository.createCustomer(login, password);
            FacesUtils.putUserId(customer.getId());
            redirectToOverview();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer already exits"));
        }
    }

    public boolean isCustomerExist() {
        return customerRepository.findUserByLogin(login) != null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private void redirectToOverview() {
        FacesUtils.redirect("overview.xhtml");
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
