package com.dam.api_torneo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.api_torneo.Model.Estadio;
import com.dam.api_torneo.Repository.EstadioRepository;

/**
 * Capa de Servicio (@Service): Contiene la lógica de negocio de la aplicación.
 * Es el "cerebro" que coordina las operaciones.
 */
@Service
public class EstadioService {

    @Autowired
    EstadioRepository estadioRepository;

    /**
     * Obtiene y devuelve una lista con todos los estadios.
     * 
     * @return la lista con todos los estadios de la base de datos.
     */
    public List<Estadio> getLista() {
        return estadioRepository.findAll();
    }

}
