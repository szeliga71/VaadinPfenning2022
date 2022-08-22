package com.example.vaadinpfenning2022.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@IdClass(ArbeitTag.class)
public class ArbeitTag implements Serializable {
  //public class ArbeitTag  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Fahrer_id;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private LocalDateTime arbeitsbeginn;
  private LocalDateTime arbeitsende;
  private int kilometer;
  private int kilometer_Rewe;
  private int pause;
  private String  fuhrerbruch;
    private String unfall;

}
