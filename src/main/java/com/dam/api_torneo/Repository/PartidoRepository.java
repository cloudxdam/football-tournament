package com.dam.api_torneo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dam.api_torneo.Model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    // mod 1.2
    List<Partido> findByFechaBetween(@Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta);

}
