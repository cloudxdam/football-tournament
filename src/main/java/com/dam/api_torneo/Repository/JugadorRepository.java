package com.dam.api_torneo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dam.api_torneo.Model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // consulta por los atributos nombre y apellidos
    List<Jugador> findByNombreAndApellidos(String nombre, String apellidos);

    // consulta si existe el nif especificado
    boolean existsByNif(String nif);
}
