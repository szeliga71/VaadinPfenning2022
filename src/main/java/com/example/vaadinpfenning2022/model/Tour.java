package com.example.vaadinpfenning2022.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@IdClass(Tour.class)
public class Tour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nrTour;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime abfahrtLager;
    private String LKWkenz;
    private LocalDateTime tourEnde;
    private int tourKilometer;
    private int fahrerId;
    private LocalDateTime arbeitsTagBegin;

//lista
}
