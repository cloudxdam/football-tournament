package com.dam.api_torneo.Service;

import java.util.List;
import java.util.Optional;

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
     * Obtiene y devuelve la lista de todos los equipos llamando al método
     * findAll() del repositorio.
     * 
     * @return lista con todos los equipos
     */
    public List<Equipo> getLista() {
        return equipoRepository.findAll();
    }

    /**
     * Busca un recurso por su id llamando al método findByid.
     * El método devuelve un objeto Optional, que es un contenedor que tendrá
     * dentro si el recurso existe o si no, estando vacío en este caso y evitando
     * así una excepción NullPointerException en el caso de que no exista.
     * 
     * @param id el id que buscamos
     * @return Optional, que contendrá si el recurso existe, si no estará vacío.
     */

    public Optional<Equipo> getRecursoPorId(Long id) {
        return equipoRepository.findById(id);
    }

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     * 
     * @param equipo el objeto que contiene los datos del cliente y que será
     *               guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     *         automáticamente
     */
    public Equipo crearObjeto(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

}
