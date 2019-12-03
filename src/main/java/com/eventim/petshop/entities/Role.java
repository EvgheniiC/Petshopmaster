package com.eventim.petshop.entities;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@DeclareRoles("ADMIN")
@Entity(name = "ROLLE")
public class Role implements Serializable {


    @EJB
    private CustomerRepository customerRepository;

    @NotNull
    @Column
    private String rollName;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Customer customer;

    @Id
    @GeneratedValue
    private long id;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }


    public boolean isAdmin() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().isUserInRole("admin");
    }


    //@RolesAllowed("admin")
    public List<Customer> allCustomerUndPetForAdmin() {
       /* ArrayList<Customer> customers = new ArrayList<>();
        for (Customer customer : customerRepository.getAllCustomer()){
            customers.add(customer);
        }
        return customers;
    }*/
        TypedQuery<Customer> query = customerRepository.entityManager.createQuery("select c from CUSTOMER c ", Customer.class);
        return query.getResultList();
    }
}
