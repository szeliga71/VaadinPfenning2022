package com.example.vaadinpfenning2022.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@IdClass(Stopp.class)
public class Stopp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tourNr;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime tourAbfahrtLager;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime marktStoppBegin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String MarktId;
//lista

}
