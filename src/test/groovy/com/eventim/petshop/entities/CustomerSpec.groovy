package com.eventim.petshop.entities

import spock.lang.Unroll

class CustomerSpec extends spock.lang.Specification {

    def "GetPreisForPet"() {

        given: 'a Сustomer'
        Customer customer = new Customer()

        and: 'a List of Treatment with various preces'
        petList.get(0).treatments = treatmentList

        and: 'a Customer with pets'
        customer.pets = petList

        when: 'getPreisForPet() is invoked'
        BigDecimal result = customer.getPreisForAllPetsStream()

        then: 'result is as expected'
        result == expectedResult

        where: 'inputs are varied'
        petList     | treatmentList                                              || expectedResult
        [new Pet()] | [new Treatment(preis: 30.10), new Treatment(preis: 72.29)] || 102.39
        [new Pet()] | [new Treatment(preis: 78.36), new Treatment(preis: 79.26)] || 157.62
    }
}
