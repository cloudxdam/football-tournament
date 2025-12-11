package com.dam.api_torneo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Clase de entidad que actúa como modelo que define la estructura de los datos.
 * Esta clase Java se mapea a tabla Equipo de la base de datos.
 */

@Entity
@Table(name = "Estadio")
@Data
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadio;
    private String nombre;
    private int aforo;

}
