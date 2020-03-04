package com.eventim.petshop.entities;


import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class CustomerRepository extends AbstractRepository {

    @EJB
    RoleRepository roleRepository ;

    public Customer createCustomer(String login, String password, Role role) {
        Customer customer =  null;
        try{
            customer = new Customer();
            customer.setLogin(login);
            customer.setPassword(password);
            customer.setRole(role);
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

    public List findAllCustomers() {
        return entityManager.createQuery(
                "SELECT c FROM CUSTOMER c").getResultList();
    }

}
