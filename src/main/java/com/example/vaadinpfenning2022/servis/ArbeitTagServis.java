package com.example.vaadinpfenning2022.servis;


import com.example.vaadinpfenning2022.model.ArbeitTag;
import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.repository.ArbeitTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArbeitTagServis {


    private final ArbeitTagRepository arbeitTagRepository;



    public List<ArbeitTag> getArbeitTag(){

        return arbeitTagRepository.findAll();
    }


    public List<ArbeitTag> findAllArbeitTag() {
        return arbeitTagRepository.findAll();
    }

   // public ArbeitTag getSingleArbeitTag(long id){

     //   return arbeitTagRepository.findById(id)
       //         .orElseThrow();
    //}

    public List<ArbeitTag> findAllArbeitTages(String stringFilter) {
        /*if (stringFilter == null || stringFilter.isEmpty()) {
            return arbeitTagRepository.findAll();
        } else {
            return arbeitTagRepository.search(stringFilter);*/

            return arbeitTagRepository.findAll();
        //}
    }

    public long countArbeitTages() {
        return arbeitTagRepository.count();
    }
    public void deleteArbeitTag(ArbeitTag arbeitTag) {
        arbeitTagRepository.delete(arbeitTag);
    }

    public void saveArbeitTag(ArbeitTag arbeitTag) {
        if (arbeitTag == null) {
            System.err.println("Arbeit Tag is null. Are you sure you have connected your form to the application?");
            return;
        }
        arbeitTagRepository.save(arbeitTag);
    }
}
