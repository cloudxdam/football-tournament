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

// anotación que marca la clase como entidad
@Entity
// anotación que especifica el nombre de esta clase en la base de datos
@Table(name = "Equipo")
// anotación que indica a Lombok que genere el código faltante (getters, etc)
@Data
public class Equipo {

    // anotación que identifica al campo como el Id de la entidad
    @Id
    // anotación que indica la estrategia (mecanismo) de generación del Id a
    // Hibernate para que lo asigne automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;
    private String nombre;

}
