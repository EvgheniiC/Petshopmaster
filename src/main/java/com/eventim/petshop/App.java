package com.eventim.petshop;

import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.CustomerRepository;
import com.eventim.petshop.entities.Role;
import com.eventim.petshop.entities.RoleRepository;

import javax.annotation.PostConstruct;
import javax.annotation.processing.RoundEnvironment;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager=true)
@ApplicationScoped
public class App {
    @EJB
    private RoleRepository roles;

    @EJB
    private CustomerRepository customerRepository;


    @PostConstruct
    public void startup() {
        Role admin = roles.createRole("admin");
        Role user = roles.createRole("user");
        customerRepository.createCustomer("admin","admin",admin);
        customerRepository.createCustomer("user","user",user);


    }


}
