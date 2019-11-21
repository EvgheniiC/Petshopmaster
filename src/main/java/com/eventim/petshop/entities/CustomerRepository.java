package com.eventim.petshop.entities;

import javax.ejb.Stateful;

@Stateful
public class CustomerRepository extends AbstractRepository {

    public Customer createCustomer(String login, String password) {
        Customer customer = new Customer();
        customer.setLogin(login);
        customer.setPassword(password);
        entityManager.persist(customer);
        return customer;
    }

    public Customer findUserByLoginAndPassword(String login, String password) {
        return find(Customer.class, Customer.FIND_BY_USERNAME_AND_PASSWORD, login, password);
    }

    public Customer findCostumerById(Integer userId) {
        return entityManager.find(Customer.class, userId);
    }

    public void addPetToCustomer(Integer customerId, Pet pet) {
        Customer customer = findCostumerById(customerId);
        customer.getPets().add(pet);
    }
}
