package com.example.vaadinpfenning2022.repository;

import com.example.vaadinpfenning2022.model.Fahrer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FahrerRepository extends JpaRepository<Fahrer,Long> {

    @Query("select f from Fahrer f " +
            "where lower(f.name) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(f.vorname) like lower(concat('%', :searchTerm, '%'))")
    List<Fahrer> search(@Param("searchTerm") String searchTerm);
}

