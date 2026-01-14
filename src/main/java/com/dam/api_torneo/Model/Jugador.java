package com.dam.api_torneo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Clase de entidad que actúa como modelo que define la estructura de los datos.
 * Esta clase Java se mapea a la tabla Jugador de la base de datos.
 */
@Entity
@Table(name = "Jugador")
@Data
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJugador;

    private String nif;
    private String nombre;
    private String apellidos;

    // relación muchos jugadores pertenecen a un equipo
    @ManyToOne
    // Nombre de la columna (FK) en la tabla 'jugador'
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

}
