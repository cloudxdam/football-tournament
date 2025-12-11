package com.dam.api_torneo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dam.api_torneo.Model.Equipo;

/**
 * Capa de acceso a datos (DAO). Su única función es hablar con la base de datos
 * (hacer consultas, inserciones, etc.). Gracias a Spring Data JPA, apenas
 * hemos tenido que escribir código aquí.
 * 
 * Extiende de JpaRepository<T, ID>
 */

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

}
