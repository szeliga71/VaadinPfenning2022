package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.model.MarktLiferung;
import com.example.vaadinpfenning2022.repository.MarktLiferungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarktLiferungServis {

    private final MarktLiferungRepository marktLiferungRepository;
}
