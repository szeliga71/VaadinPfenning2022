package com.example.vaadinpfenning2022.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

public class Fahrer {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)


   private int id;
    private int Id_pf;
    private int id_rewe;
    private String name;
    private String vorname;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Fahrer_id", updatable = false, insertable = false)
    //@JoinColumn(name = "Fahrer_id", updatable = false, insertable = false)
    private List<ArbeitTag>arbeitTagList;
}

