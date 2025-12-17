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
     * Crea un nuevo objeto en la base de datos, si el nif no se ha registrado
     * anteriormente.
     *
     * @param jugador el objeto que contiene los datos del cliente y que será
     * guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     * automáticamente
     */
    public Jugador crearRecurso(Jugador jugador) {

        if (!jugadorRepository.existsByNif(jugador.getNif())) {
            return jugadorRepository.save(jugador);

        } else {
            throw new RuntimeException("Ya existe un recurso con ese atributo");
        }

    }

    /**
     * Modifica un recurso en la base de datos localizándolo por su id.
     *
     * @param id el id del recurso que el cliente quiere modificar.
     * @param estadio el recurso con los datos que proporciona el cliente.
     * @return contenedor con el objeto modificado o vacío si no encuentra el
     * id.
     */
    public Optional<Jugador> modificarRecurso(Long id, Jugador jugador) {

        Optional<Jugador> jugadorBuscado = jugadorRepository.findById(id);

        if (jugadorBuscado.isPresent()) {
            Jugador jugadorAModificar = jugadorBuscado.get();
            jugadorAModificar.setNif(jugador.getNif());
            jugadorAModificar.setNombre(jugador.getNombre());
            jugadorAModificar.setApellidos(jugador.getApellidos());

            return Optional.of(jugadorAModificar);

        } else {
            return Optional.empty();
        }
    }

    /**
     * Borra / Elimina un recurso de la base de datos. Primero busca si existe
     * el id proporcionado por el cliente. En caso de que sí, procede a borrar
     * el recurso y devuelve un contenedor con dicho recurso. En caso de que no,
     * devuelve un contenedor vacío.
     *
     * @param id el id del recurso a borrar, proporcionado por el cliente.
     * @return el recurso si se encontró o contenedor vacío.
     */
    public Optional<Jugador> borrarRecurso(Long id) {

        Optional<Jugador> jugadorBuscado = jugadorRepository.findById(id);

        if (jugadorBuscado.isPresent()) {
            jugadorRepository.deleteById(id);

            return jugadorBuscado;

        } else {
            return Optional.empty();
        }
    }

    /**
     * Get Compuesto
     */
    public List<Jugador> buscarConParametros(String nombre, String apellidos) {

        return jugadorRepository.findByNombreAndApellidos(nombre, apellidos);

    }

}
