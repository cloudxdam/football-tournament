package com.dam.api_torneo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

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

    /**
     * Modifica un recurso en la base de datos. Primero, lo localiza por su id.
     * Si no lo encuentra, devuelve un contenedor vacío. Si lo encuenta, modifica
     * el nombre del objeto encontrado por el nombre del objeto proporcionado por
     * el cliente, lo guarda en la base de datos y devuelve un contenedor con el
     * objeto modificado.
     * 
     * @param id     el id del recurso que el cliente quiere modificar.
     * @param equipo el recurso con los datos que proporciona el cliente.
     * @return contenedor con el objeto modificado o vacío si no encuentra el id.
     */

    public Optional<Equipo> modificarRecurso(Long id, Equipo equipo) {
        // primero buscamos el recurso que corresponde al id proporcionado por el
        // cliente
        Optional<Equipo> equipoBuscado = equipoRepository.findById(id);
        // si existe, obtenemos los datos del objeto al que corresponde el id
        if (equipoBuscado.isPresent()) {
            Equipo equipoAModificar = equipoBuscado.get();
            // modificamos el nombre del objeto obtenido por el que proporcionó el cliente
            equipoAModificar.setNombre(equipo.getNombre());
            // guardamos los datos en la base de datos
            equipoRepository.save(equipoAModificar);
            return Optional.of(equipoAModificar);

        } else {
            return Optional.empty();
        }
    }

}
