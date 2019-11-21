package com.eventim.petshop.Login;

import com.eventim.petshop.FacesUtils;
import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.CustomerRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

@ManagedBean
public class Login implements Serializable {

    @EJB
    private CustomerRepository customerRepository;

    private String password;
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
            customer = customerRepository.findUserByLoginAndPassword(login, password);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        FacesUtils.putUserId(customer.getId());
        redirectToOverview();
    }

    public void registerNewUser(ActionEvent actionEvent) {
        Customer customer = customerRepository.createCustomer(login, password);
        FacesUtils.putUserId(customer.getId());
        redirectToOverview();
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
}
