package com.eventim.petshop.Login;

import com.eventim.petshop.FacesUtils;
import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.CustomerRepository;
import com.eventim.petshop.entities.Role;
import com.eventim.petshop.entities.RoleRepository;
import com.eventim.petshop.view.FirstPage;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean
public class Login implements Serializable {

    Customer customer;

    @EJB
    private CustomerRepository customerRepository;

    @EJB
    private RoleRepository roleRepository;

    private FirstPage firstPage;
    public Login() {
    }

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

    String role;


    public List<Role> getRoles(){
       return  roleRepository.findAll();
    }

    public void doLogin(ActionEvent actionEvent) {
       //Customer customer;
        try {
            customer = customerRepository.findUserByLogin(login);
            if (customer!=null && customer.getPassword().equals(password)){
                FacesUtils.putUserId(customer.getId());
                redirect();
            }
            else {
                customer = null;

            }

        } catch (Exception e) {
            e.printStackTrace();
            return ;
        }

    }

    public void registerNewUser(ActionEvent actionEvent) throws Exception {
        if (!isCustomerExist()) {
            Role roleCustomer = roleRepository.findOne(role);
            //Customer
            customer = customerRepository.createCustomer(login, password,roleCustomer);

            FacesUtils.putUserId(customer.getId());
           redirect();

        }
         else{ FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer already exits"));}

    }
    // проверка
    public  void redirect(){
        if (customer!=null){
            if (customer.getRole().getRollName().equalsIgnoreCase("admin")){
                redirectToAdmin();

            }
            else {
                redirectToOverview();
            }
        }


    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    private void redirectToAdmin() {
        FacesUtils.redirect("admin.xhtml");
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        customer = null;
        try {
            context.getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
