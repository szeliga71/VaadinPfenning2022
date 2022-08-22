package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.repository.StoppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoppServis {

    private final StoppRepository stoppRepository;
}
