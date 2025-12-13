package com.dam.api_torneo.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * Busca un recurso por su id.
     * 
     * @param id el id que buscamos
     * @return Optional, que contendrá si el recurso existe, si no estará vacío.
     */

    public Optional<Jugador> getRecursoPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     * 
     * @param jugador el objeto que contiene los datos del cliente y que será
     *                guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     *         automáticamente
     */
    public Jugador crearObjeto(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }
}
