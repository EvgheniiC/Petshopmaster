package com.eventim.petshop.Login

import com.eventim.petshop.entities.Customer
import com.eventim.petshop.entities.CustomerRepository
import spock.lang.Specification

import javax.persistence.EntityManager

class LoginSpec extends Specification {
    private static final String LOGIN_NAME = "test"
    private static final String LOGIN_PW = "test"

    def "IsCustomerExist"() {
        given: 'a persisted customer'
        Customer customer = new Customer();

        and:' a CustomerRepository'
        CustomerRepository repo = Stub(CustomerRepository) {
            findUserByLoginAndPassword(LOGIN_NAME,LOGIN_PW) >> customer
        }

        and: 'a Login class'
        Login login = new Login(customerRepository: repo, login: LOGIN_NAME, password: LOGIN_PW)

        when:'IsCustomerExist is invoked'
        boolean isCustomerExists = login.isCustomerExist()

        then:'result is as expected'
        isCustomerExists
    }

    def "Negative test: customer does not exist"() {
        given: 'a persisted customer'
        Customer customer = new Customer();

        and:' a CustomerRepository'
        CustomerRepository repo = Stub(CustomerRepository) {
            findUserByLoginAndPassword(LOGIN_NAME,LOGIN_PW) >> null
        }

        and: 'a Login class'
        Login login = new Login(customerRepository: repo, login: LOGIN_NAME, password: LOGIN_PW)

        when:'IsCustomerExist is invoked'
        boolean shouldNotExist = login.isCustomerExist()

        then:'result is as expected'
        !shouldNotExist
    }
}
