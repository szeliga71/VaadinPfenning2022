package com.example.vaadinpfenning2022.controller;


import com.example.vaadinpfenning2022.model.ArbeitTag;
import com.example.vaadinpfenning2022.servis.ArbeitTagServis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArbeitTagController {

    private final ArbeitTagServis arbeitTagServis;

    @GetMapping("/Arbeit_Tags")
    public List<ArbeitTag>getArbeitTags(){

        return arbeitTagServis.getArbeitTag();
    }

   // @GetMapping("/Arbeit_Tag/{id}")
    //public ArbeitTag getSingleArbeitTag(@PathVariable long id){

      //  return arbeitTagServis.getSingleArbeitTag(id);
    //}
}
