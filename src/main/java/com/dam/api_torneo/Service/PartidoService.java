package com.dam.api_torneo.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * Busca un recurso por su id.
     * 
     * @param id el id que buscamos
     * @return Optional, que contendrá si el recurso existe, si no estará vacío.
     */

    public Optional<Partido> getRecursoPorId(Long id) {
        return partidoRepository.findById(id);
    }

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     * 
     * @param partido el objeto que contiene los datos del cliente y que será
     *                guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     *         automáticamente
     */
    public Partido crearObjeto(Partido partido) {
        return partidoRepository.save(partido);
    }

}
