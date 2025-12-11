package com.dam.api_torneo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.api_torneo.Model.Jugador;
import com.dam.api_torneo.Repository.JugadorRepository;

/**
 * Capa de Servicio (@Service): Contiene la lógica de negocio de la aplicación.
 * Es el "cerebro" que coordina las operaciones.
 */

@Service
public class JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    /**
     * Obtiene y devuelve una lista con todos los jugadores.
     * 
     * @return la lista con todos los jugadores de la base de datos.
     */
    public List<Jugador> getLista() {
        return jugadorRepository.findAll();
    }
}
