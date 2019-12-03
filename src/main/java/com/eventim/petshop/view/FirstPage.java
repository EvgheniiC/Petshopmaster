package com.eventim.petshop.view;

import com.eventim.petshop.FacesUtils;
import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.Pet;
import com.eventim.petshop.entities.Role;
import com.eventim.petshop.manager.CustomerManager;
import com.eventim.petshop.manager.PetManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.Collection;

@Named
@ManagedBean
public class FirstPage {

    @EJB
    private PetManager petManager;

    @EJB
    private CustomerManager customerManager;

    private Customer customer;
    private Role role;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private String petName;

    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void buttonAction(ActionEvent actionEvent) {
        petManager.createPet(FacesUtils.getUserId(), petName);
    }

    public void buttonDeleteAction(ActionEvent actionEvent) {
       petManager.deletePet(FacesUtils.getUserId(), petName);
    }

    public Collection<Pet> getPets() {
        return customerManager.getPetsForCustomer(FacesUtils.getUserId());
    }
}
