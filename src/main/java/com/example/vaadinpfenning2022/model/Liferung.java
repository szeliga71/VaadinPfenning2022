package com.example.vaadinpfenning2022.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@IdClass(Liferung.class)
public class Liferung implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String WareId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime stoppbegin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String MarktId;
    private int menge;

}
