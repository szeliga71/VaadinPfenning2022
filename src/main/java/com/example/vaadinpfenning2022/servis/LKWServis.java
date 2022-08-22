package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.repository.LKWRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LKWServis {

    private final LKWRepository lkwRepository;
}
