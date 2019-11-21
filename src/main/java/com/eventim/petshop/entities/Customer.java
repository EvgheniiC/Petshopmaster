package com.eventim.petshop.entities;

import org.apache.openjpa.persistence.jdbc.Unique;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NamedQuery(name = Customer.FIND_BY_USERNAME_AND_PASSWORD, query = "SELECT c FROM CUSTOMER c WHERE c.login = ?1 AND c.password = ?2")

@Entity(name = "CUSTOMER")
public class Customer {

    public static final String FIND_BY_USERNAME_AND_PASSWORD = "findByUsernameAndPassword";

    EntityManager em;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @Unique
    private String login;

    @Column
    private String password;

    @OneToMany
    private List<Pet> pets;

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

    public List<Pet> getPets() {
     /*   List<Pet> pets = new ArrayList<>();
        Query query = em.createQuery("SELECT  pet FROM CUSTOMER");
        List<Customer> customerList = query.getResultList();
        for (Customer customer: customerList){
            pets.add((Pet) customer.getPets());
        }*/
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public BigDecimal getPreisForAllPetsStream() {
        return pets.stream()
                .map(Pet::getTreatments)
                .flatMap(Collection::stream)
                .map(Treatment::getPreis)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
