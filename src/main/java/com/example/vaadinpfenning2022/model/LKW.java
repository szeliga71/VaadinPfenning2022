package com.example.vaadinpfenning2022.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class LKW {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String kenz;
    private String marke;
    private int nr_rewe;
}
