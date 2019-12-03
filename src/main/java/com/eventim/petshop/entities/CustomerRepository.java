package com.eventim.petshop.entities;


import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;

@Stateful
public class CustomerRepository extends AbstractRepository {


   // private Collection<Customer> customers;

    public Customer createCustomer(String login, String password) {
        Customer customer =  null;
        try{
            customer = new Customer();
            customer.setLogin(login);
            customer.setPassword(password);
            entityManager.persist(customer);
          }

        catch (Exception e){
            System.out.println(e.toString());
        }
        return customer;
    }

    public Customer findUserByLogin(String login) {
             Customer customer = null;
            try{
                customer = find(Customer.class, "CUSTOMER.findByLogin", login);

            }catch (Exception x){
                System.out.println(x.toString());
            }
            return  customer;
    }

    public Customer findCostumerById(Integer userId) {
        return entityManager.find(Customer.class, userId);
    }

    public void addPetToCustomer(Integer customerId, Pet pet) {
        Customer customer = findCostumerById(customerId);
        customer.addPet(pet);
    }
    public void deletePetForCustomer(Integer customerId, Pet pet) {
        Customer customer = findCostumerById(customerId);
        customer.deletePet(pet);
    }

   // public Collection<Customer> getAllCustomer(){
   //   return customers;
  //  }

}
