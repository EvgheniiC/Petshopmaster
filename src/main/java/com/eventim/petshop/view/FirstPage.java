package com.eventim.petshop.view;

import com.eventim.petshop.FacesUtils;
import com.eventim.petshop.entities.Pet;
import com.eventim.petshop.manager.PetManager;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


//@ManagedBean(name = "firstPage", eager = true)
@ManagedBean
public class FirstPage {

    @EJB
    private PetManager petManager;

    private String petName;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public PetManager getPetManager() {
        return petManager;
    }

    public void setPetManager(PetManager petManager) {
        this.petManager = petManager;
    }

    public void buttonAction(ActionEvent actionEvent) {
        petManager.createPet(FacesUtils.getUserId(), "NOT IMPLEMENTED YET");
    }

}
