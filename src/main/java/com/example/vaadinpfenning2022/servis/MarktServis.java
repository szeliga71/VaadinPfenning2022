package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.repository.MarktRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarktServis {

    private final MarktRepository marktRepository;
}
