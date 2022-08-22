package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.repository.FahrerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FahrerServis {

    private final FahrerRepository fahrerRepository;


    public List<Fahrer> findAllFahrer(){

        return fahrerRepository.findAll();
    }
    public Fahrer addFahrer(Fahrer fahrer){
        return fahrerRepository.save(fahrer);
    }
    public void delFahrerById(Long id) {
        fahrerRepository.deleteById(id);
    }


    //Vaadin

    public Fahrer findById(Long id){
        return fahrerRepository.findById(id).orElseThrow();
    }

    public List<Fahrer> findAllFahrers(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return fahrerRepository.findAll();
        } else {
            return fahrerRepository.search(stringFilter);
        }
    }

    public long countFahrers() {
        return fahrerRepository.count();
    }
    public void deleteFahrer(Fahrer fahrer) {
        fahrerRepository.delete(fahrer);
    }

    public void saveFahrer(Fahrer fahrer) {
        if (fahrer == null) {
            System.err.println("Fahrer is null. Are you sure you have connected your form to the application?");
            return;
        }
        fahrerRepository.save(fahrer);
    }


}
