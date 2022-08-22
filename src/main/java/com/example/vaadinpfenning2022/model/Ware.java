package com.example.vaadinpfenning2022.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Ware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String beziechnung;

}
