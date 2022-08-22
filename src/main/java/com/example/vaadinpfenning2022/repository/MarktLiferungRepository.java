package com.example.vaadinpfenning2022.repository;

import com.example.vaadinpfenning2022.model.MarktLiferung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarktLiferungRepository extends JpaRepository<MarktLiferung,Long> {
}
