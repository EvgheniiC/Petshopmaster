package com.eventim.petshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Treatment")
public class Treatment {

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="pets")
    private Pet pets;


    @Column(name = "preis")
    private BigDecimal preis;


    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }






}
