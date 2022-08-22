package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.repository.FahrerRepository;
import com.example.vaadinpfenning2022.repository.LiferungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiferungServis {


    private final LiferungRepository liferungRepository;
}
