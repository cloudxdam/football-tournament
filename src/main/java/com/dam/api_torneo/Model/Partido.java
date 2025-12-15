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
 * Esta clase Java se mapea a la tabla Partido de la base de datos.
 */

@Entity
@Table(name = "Partido")
@Data
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartido;
    private String fecha;
    private String resultado;

    // relación un equipo juega muchos partidos, para ver en los partidos
    // registrados (jugados) los equipos implicados
    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

}
