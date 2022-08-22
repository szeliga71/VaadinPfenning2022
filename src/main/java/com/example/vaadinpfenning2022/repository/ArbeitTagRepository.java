package com.example.vaadinpfenning2022.repository;

import com.example.vaadinpfenning2022.model.ArbeitTag;
import com.example.vaadinpfenning2022.model.Fahrer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArbeitTagRepository extends JpaRepository<ArbeitTag,Long> {

    @Query("select at from ArbeitTag at " +
            "where lower(at.arbeitsbeginn) like lower(concat('%', :searchTerm, '%')) ")
    //+
      //      "or lower(f.vorname) like lower(concat('%', :searchTerm, '%'))")
    List<ArbeitTag> search(@Param("searchTerm") String searchTerm);



}
