package com.eventim.petshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;


@NamedQueries({
        @NamedQuery(name ="CUSTOMER.findByLogin", query = "SELECT c FROM CUSTOMER c WHERE c.login = ?1"),
        @NamedQuery(name ="CUSTOMER.findAllCUSTOMER", query = "SELECT c FROM CUSTOMER c ")})
@Entity(name = "CUSTOMER")
public class Customer {

    public static final String FIND_BY_USERNAME = "SELECT c FROM CUSTOMER c WHERE c.login = ?1";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @OneToMany( fetch = FetchType.EAGER)
    private List<Pet> pets = new ArrayList<>();

    @ManyToOne
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Collection<Pet> getPets() {
        return this.pets;
    }


    public void addPet(Pet pet){
        pets.add(pet);
    }

    public BigDecimal getPreisForAllPetsStream() {
        return pets.stream()
                .map(Pet::getTreatments)
                .flatMap(Collection::stream)
                .map(Treatment::getPreis)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", pets=" + pets +
                '}';
    }

    public boolean isPetExist(String name){
        for (Pet pet: getPets()){
            if (pet.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
