package com.dam.api_torneo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.api_torneo.Model.Partido;
import com.dam.api_torneo.Repository.PartidoRepository;

/**
 * Capa de Servicio (@Service): Contiene la lógica de negocio de la aplicación.
 * Es el "cerebro" que coordina las operaciones.
 */

@Service
public class PartidoService {

    @Autowired
    PartidoRepository partidoRepository;

    /**
     * Obtiene y devuelve una lista con todos los resultados de los partidos.
     * 
     * @return la lista con todos los resultados de los partidos de la base de
     *         datos.
     */
    public List<Partido> getLista() {
        return partidoRepository.findAll();
    }

}
