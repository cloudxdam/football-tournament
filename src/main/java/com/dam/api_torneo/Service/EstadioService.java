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
     * @return el Estadio encontrado o RuntimeException si no lo encuentra.
     */

    public Estadio getRecursoPorId(Long id) {

        Optional<Estadio> estadioBuscado = estadioRepository.findById(id);

        if (estadioBuscado.isPresent()) {
            return estadioBuscado.get();

        } else {
            throw new RuntimeException("No se ha encontrado el estadio con el Id especificado.");
        }
    }

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     * 
     * @param estadio el objeto que contiene los datos del cliente y que será
     *                guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     *         automáticamente
     */
    public Estadio crearRecurso(Estadio estadio) {

        return estadioRepository.save(estadio);
    }

    /**
     * Modifica un recurso en la base de datos localizándolo por su id.
     * 
     * @param id      el id del recurso que el cliente quiere modificar.
     * @param estadio el recurso con los datos que proporciona el cliente.
     * @return el objeto modificado o RuntimeExceptoion si no encuentra el id.
     */

    public Estadio modificarRecurso(Long id, Estadio estadio) {

        Optional<Estadio> estadioBuscado = estadioRepository.findById(id);

        if (estadioBuscado.isPresent()) {
            Estadio estadioAModificar = estadioBuscado.get();
            estadioAModificar.setNombre(estadio.getNombre());
            estadioRepository.save(estadioAModificar);

            return estadioAModificar;

        } else {
            throw new RuntimeException("No se ha encontrado el equipo con el Id especificado.");
        }
    }

    /**
     * Borra / Elimina un recurso de la base de datos. Primero busca si existe
     * el id proporcionado por el cliente. En caso de que sí, procede a borrarlo. En
     * caso de que no, lanzará una excepción.
     *
     * @param id el id del recurso a borrar, proporcionado por el cliente.
     * @return el recurso si se encontró o RuntimeException si no.
     */
    public Estadio borrarRecurso(Long id) {

        Optional<Estadio> estadioBuscado = estadioRepository.findById(id);

        if (estadioBuscado.isPresent()) {
            Estadio estadoABorrar = estadioBuscado.get();

            estadioRepository.deleteById(id);

            return estadoABorrar;

        } else {
            throw new RuntimeException("No se ha encontrado el equipo con el Id especificado.");
        }
    }

}
