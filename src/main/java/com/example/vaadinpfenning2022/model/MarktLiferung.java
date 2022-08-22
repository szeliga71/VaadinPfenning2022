package com.example.vaadinpfenning2022.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@IdClass(MarktLiferung.class)
public class MarktLiferung implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String marktId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime stoppbegin;
    private LocalDateTime stoppende;

//lista towarow

}
