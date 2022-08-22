package com.example.vaadinpfenning2022.repository;

import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.model.Liferung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiferungRepository extends JpaRepository<Liferung,Long>
{
}
