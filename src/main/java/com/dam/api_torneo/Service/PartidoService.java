package com.dam.api_torneo.Service;

import java.time.LocalDate;
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
     * datos.
     */
    public List<Partido> getLista() {

        return partidoRepository.findAll();
    }

    /**
     * Busca un recurso por su id.
     *
     * @param id el id que buscamos.
     * @return El recurso si existe, si no lanza RuntimeException.
     */
    public Partido getRecursoPorId(Long id) {

        Optional<Partido> partidoBuscado = partidoRepository.findById(id);

        if (partidoBuscado.isPresent()) {
            return partidoBuscado.get();

        } else {
            throw new RuntimeException("No se ha encontrado el estadio con el Id especificado.");
        }
    }

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     *
     * @param partido el objeto que contiene los datos del cliente y que será
     * guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     * automáticamente
     */
    public Partido crearRecurso(Partido partido) {

        return partidoRepository.save(partido);
    }

    /**
     * Modifica un recurso en la base de datos localizándolo por su id.
     *
     * @param id el id del recurso que el cliente quiere modificar.
     * @param estadio el recurso con los datos que proporciona el cliente.
     * @return el objeto modificado o RuntimeException no encuentra el id.
     */
    public Partido modificarRecurso(Long id, Partido partido) {

        Optional<Partido> partidoBuscado = partidoRepository.findById(id);

        if (partidoBuscado.isPresent()) {
            Partido partidoAModificar = partidoBuscado.get();
            partidoAModificar.setResultado(partido.getResultado());

            return partidoRepository.save(partidoAModificar);

        } else {
            throw new RuntimeException("No se ha encontrado el estadio con el Id especificado.");
        }
    }

    /**
     * Borra / Elimina un recurso de la base de datos. Primero busca si existe
     * por el id proporcionado por el cliente. En caso de que sí, borrar el
     * recurso. En caso de que no, lanzará una excepción.
     *
     * @param id el id del recurso a borrar, proporcionado por el cliente.
     * @return el recurso si se encontró o RuntimeException.
     */
    public Partido borrarRecurso(Long id) {

        Optional<Partido> partidoBuscado = partidoRepository.findById(id);

        if (partidoBuscado.isPresent()) {
            Partido partidoABorrar = partidoBuscado.get();
            partidoRepository.deleteById(id);

            return partidoABorrar;

        } else {
            throw new RuntimeException("No se ha encontrado el estadio con el Id especificado.");
        }
    }

    // mod 1.2
    /**
     * Realiza una búsqueda por rango de fechas.
     *
     */
    public List<Partido> buscarPorFechas(LocalDate desde, LocalDate hasta) {

        return partidoRepository.findByFechaBetween(desde, hasta);
    }

}
