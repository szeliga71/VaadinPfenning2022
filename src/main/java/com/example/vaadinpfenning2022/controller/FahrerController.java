package com.example.vaadinpfenning2022.controller;


import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.servis.FahrerServis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FahrerController {

    private final FahrerServis fahrerServis;


    @GetMapping("Fahrer")
    public List<Fahrer>getFahrer(){
        return fahrerServis.findAllFahrer();
    }

    @GetMapping("Fahrer/{id}")
    public Fahrer getFahrerById(@PathVariable Long id){
     return   fahrerServis.findById(id);
    }

    @PostMapping("addFahrer")
    public Fahrer addFahrer(@RequestBody Fahrer fahrer){
        return fahrerServis.addFahrer(fahrer);}

    @DeleteMapping("delFahrer/{id}")
    public void deleteFahrerById(@PathVariable Long id){
        fahrerServis.delFahrerById(id);
    }




}
