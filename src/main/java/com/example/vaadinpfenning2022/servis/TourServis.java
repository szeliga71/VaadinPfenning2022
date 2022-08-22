package com.example.vaadinpfenning2022.servis;

import com.example.vaadinpfenning2022.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourServis {

    private final TourRepository tourRepository;
}
