package com.example.vaadinpfenning2022.repository;

import com.example.vaadinpfenning2022.model.LKW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LKWRepository extends JpaRepository<LKW,Long> {
}
