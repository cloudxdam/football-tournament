package com.dam.api_torneo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.api_torneo.Model.Jugador;
import com.dam.api_torneo.Repository.JugadorRepository;

import jakarta.transaction.Transactional;

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
     * @param id el id que buscamos.
     * @return El jugador buscado o RuntimeException si no se encuentra.
     */
    public Jugador getRecursoPorId(Long id) {

        Optional<Jugador> jugadorBuscado = jugadorRepository.findById(id);

        if (jugadorBuscado.isPresent()) {
            return jugadorBuscado.get();

        } else {
            throw new RuntimeException("No se ha encontrado el jugador con el Id especificado.");
        }

    }

    /**
     * Crea un nuevo objeto en la base de datos, si el nif no se ha registrado
     * anteriormente.
     *
     * @param jugador el objeto que contiene los datos del cliente y que será
     * guardado.
     * @return El objeto que es guardado en la base de datos con su id generado
     * automáticamente o RuntimeException si el NIF ya está registrado.
     */
    public Jugador crearRecurso(Jugador jugador) {

        if (!jugadorRepository.existsByNif(jugador.getNif())) {
            return jugadorRepository.save(jugador);

        } else {
            throw new RuntimeException("NIF Duplicado");
        }

    }

    /**
     * Modifica un recurso en la base de datos localizándolo por su id.
     *
     * @param id el id del recurso que el cliente quiere modificar.
     * @param jugador el recurso con los datos que proporciona el cliente.
     * @return el objeto modificado o RuntimeExceptoion si no encuentra el id.
     */
    public Jugador modificarRecurso(Long id, Jugador jugador) {

        Optional<Jugador> jugadorBuscado = jugadorRepository.findById(id);

        if (jugadorBuscado.isPresent()) {

            Jugador jugadorAModificar = jugadorBuscado.get();
            jugadorAModificar.setNif(jugador.getNif());
            jugadorAModificar.setNombre(jugador.getNombre());
            jugadorAModificar.setApellidos(jugador.getApellidos());

            return jugadorRepository.save(jugadorAModificar);

        } else {
            throw new RuntimeException("No se ha encontrado el jugador con el Id especificado.");
        }
    }

    /**
     * Borra / Elimina un recurso de la base de datos. Primero busca si existe
     * el id proporcionado por el cliente. En caso de que sí, procede a
     * borrarlo. En caso de que no, lanzará una excepción.
     *
     * @param id el id del recurso a borrar, proporcionado por el cliente.
     * @return el recurso si se encontró o RuntimeException si no.
     */
    public Jugador borrarRecurso(Long id) {

        Optional<Jugador> jugadorBuscado = jugadorRepository.findById(id);

        if (jugadorBuscado.isPresent()) {
            Jugador jugadorABorrar = jugadorBuscado.get();
            jugadorRepository.deleteById(id);

            return jugadorABorrar;

        } else {
            throw new RuntimeException("No se ha encontrado el jugador con el Id especificado.");
        }
    }

    /**
     * Realiza una búsqueda compuesta de jugadores basándose en la combiación de
     * los atributos 'nombre' y 'apellidos'.
     *
     * @param nombre El nombre del jugador buscado.
     * @param apellidos Apellidos del jugador buscado.
     * @return Lista de jugadores que coincidan con los parámetros
     * especificados.
     */
    public List<Jugador> buscarConParametros(String nombre, String apellidos) {

        return jugadorRepository.findByNombreAndApellidos(nombre, apellidos);
    }

    /**
     * Guarda una lista de jugadores en la base de datos. Comprueba que los NIF
     * no estén registrados anteriormente y que su nombre no sea 'ERROR'. En el
     * caso de que alguna de esas validaciones falle, lanzará una excepción y
     * hará un rollback (dará marcha atŕas y no guardará nada) gracias a la
     * anotación @Transactional.
     *
     * @param jugadores lista de jugadores a guardar en la base de datos.
     * @return lista con los jugadores que sea han guardado.
     */
    @Transactional
    public List<Jugador> saveAll(List<Jugador> jugadores) {

        List<Jugador> jugadoresGuardados = new ArrayList<>();

        for (Jugador jugador : jugadores) {

            if (jugadorRepository.existsByNif(jugador.getNif())) {
                throw new RuntimeException("ERROR: el NIF " + jugador.getNif() + " ya existe en la base de datos");
            }

            if (jugador.getNombre().equalsIgnoreCase("ERROR")) {
                throw new RuntimeException("ERROR en la transacción: nombre " + jugador.getNombre() + " no permitido.");
            }

            jugadoresGuardados.add(jugadorRepository.save(jugador));
        }

        return jugadoresGuardados;
    }

    /**
     * Realizar una actualización / modificación parcial del recurso. Gracias a
     * Transactional, si el nif introducido está duplicado, no se guardará
     * ninguno de los cambios.
     *
     * @param id id del Jugador
     * @param jugador Objeto jugador que "trae" las modificaciones a realizar
     * @return
     */
    @Transactional
    public Jugador parchearRecurso(Long id, Jugador jugador) {

        Optional<Jugador> jugadorBuscado = jugadorRepository.findById(id);

        if (jugadorBuscado.isPresent()) {

            Jugador jugadorEncontrado = jugadorBuscado.get();

            if (jugador.getNif() != null) {
                if (jugadorRepository.existsByNif(jugador.getNif())) {
                    throw new RuntimeException("Error en la transacción. El NIF especificado ya existe en la base de datos.");
                }
                jugadorEncontrado.setNif(jugador.getNif());
            }

            if (jugador.getNombre() != null) {
                jugadorEncontrado.setNombre(jugador.getNombre());
            }

            if (jugador.getApellidos() != null) {
                jugadorEncontrado.setApellidos(jugador.getApellidos());
            }

            return jugadorRepository.save(jugadorEncontrado);

        } else {
            throw new RuntimeException("No se ha encontrado el jugador con el Id especificado.");
        }

    }

}
