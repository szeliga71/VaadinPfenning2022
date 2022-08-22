package com.example.vaadinpfenning2022.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FahrerSerwisTEST {


    public String helloFahrerH2() {
        return "Hello Driver z bazy H2";
    }


    public String helloFahrer(){
        return"Hello Driver";
    }


}