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

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     * 
     * @param estadio el objeto que contiene los datos del cliente y que será
     *                guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     *         automáticamente
     */
    public Estadio crearObjeto(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    /**
     * Modifica un recurso en la base de datos localizándolo por su id.
     * 
     * @param id      el id del recurso que el cliente quiere modificar.
     * @param estadio el recurso con los datos que proporciona el cliente.
     * @return contenedor con el objeto modificado o vacío si no encuentra el id.
     */

    public Optional<Estadio> modificarRecurso(Long id, Estadio estadio) {
        Optional<Estadio> estadioBuscado = estadioRepository.findById(id);

        if (estadioBuscado.isPresent()) {
            Estadio estadioAModificar = estadioBuscado.get();
            estadioAModificar.setNombre(estadio.getNombre());
            estadioRepository.save(estadioAModificar);

            return Optional.of(estadioAModificar);

        } else {
            return Optional.empty();
        }
    }

}
