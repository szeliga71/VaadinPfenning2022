package com.example.vaadinpfenning2022.servis;


import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.model.Ware;
import com.example.vaadinpfenning2022.repository.WareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WareServis {

    private final WareRepository wareRepository;

    public List<Ware> findAllWare(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return wareRepository.findAll();
        } else {
            return wareRepository.search(stringFilter);
        }
    }

    public long countWare() {
        return wareRepository.count();
    }
    public void deleteWare(Ware ware) {
        wareRepository.delete(ware);
    }

    public void saveWare(Ware ware) {
        if (ware == null) {
            System.err.println("ware is null. Are you sure you have connected your form to the application?");
            return;
        }
        wareRepository.save(ware);
    }
}
