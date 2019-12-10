package com.eventim.petshop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name ="Role.findByRole", query = "SELECT c FROM Role c where c.rollName=?1")})
@Entity(name = "Role")
public class Role implements Serializable {

    @Id
    @NotNull
    @Column
    private String rollName;

    @OneToMany
    private Set<Customer> customer;



    public Role(@NotNull String rollName) {
        this.rollName = rollName;
    }

    public Role() {
    }


    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    @Override
    public String toString() {
        return rollName;
    }
}
