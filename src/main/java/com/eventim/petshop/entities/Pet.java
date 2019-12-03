package com.eventim.petshop.entities;

//import org.apache.xpath.operations.String;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.lang.String;

@Entity(name = "PET")
public class Pet {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = treatments;
    }

    @OneToMany (mappedBy="pets", fetch= FetchType.EAGER)
    private Collection<Treatment> treatments;

    public Collection<Treatment> getTreatments() {
        return treatments;
    }
}
