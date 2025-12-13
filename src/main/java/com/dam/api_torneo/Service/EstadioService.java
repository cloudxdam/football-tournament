package com.dam.api_torneo.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * Busca un recurso por su id.
     * 
     * @param id el id que buscamos
     * @return Optional, que contendrá si el recurso existe, si no estará vacío.
     */

    public Optional<Estadio> getRecursoPorId(Long id) {
        return estadioRepository.findById(id);
    }

}
