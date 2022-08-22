package com.example.vaadinpfenning2022.repository;

import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.model.Ware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WareRepository extends JpaRepository<Ware,Long> {

    @Query("select w from Ware w " +
            "where lower(w.beziechnung) like lower(concat('%', :searchTerm1, '%')) " )

    List<Ware> search(@Param("searchTerm1") String searchTerm);
}
