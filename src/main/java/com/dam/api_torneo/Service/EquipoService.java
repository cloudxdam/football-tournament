package com.dam.api_torneo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.api_torneo.Model.Equipo;
import com.dam.api_torneo.Repository.EquipoRepository;

/**
 * Capa de Servicio (@Service): Contiene la lógica de negocio de la aplicación.
 * Es el "cerebro" que coordina las operaciones.
 */

// anotación que indica que esta clase contiene la lógica de negocio de la
// aplicación.
@Service
public class EquipoService {

    // con esta anotación, Spring inyectará automáticamente el repositorio para
    // permitir el acceso a la base de datos
    @Autowired
    EquipoRepository equipoRepository;

    /**
     * obtiene y devuelve la lista de todos los equipos llamando al método
     * findAll() del repositorio.
     * 
     * @return lista con todos los equipos
     */
    public List<Equipo> getLista() {
        return equipoRepository.findAll();
    }

}
