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
     * 
     * @param id el id que buscamos
     * @return El equipo si el recurso existe, si no lanzará RuntimeException.
     */

    public Equipo getRecursoPorId(Long id) {

        Optional<Equipo> equipoBuscado = equipoRepository.findById(id);

        if (equipoBuscado.isPresent()) {
            return equipoBuscado.get();

        } else {
            throw new RuntimeException("No se ha encontrado el equipo con el Id especificado.");
        }
    }

    /**
     * Crea un nuevo objeto en la base de datos, en este caso un nuevo Equipo.
     * 
     * @param equipo el objeto que contiene los datos del cliente y que será
     *               guardado
     * @return El objeto que es guardado en la base de datos con su id generado
     *         automáticamente
     */
    public Equipo crearRecurso(Equipo equipo) {

        return equipoRepository.save(equipo);
    }

    /**
     * Modifica un recurso en la base de datos. Primero, lo localiza por su id.
     * Si lo encuenta, modifica el nombre del objeto encontrado por el nombre del
     * objeto proporcionado por el cliente, lo guarda en la base de datos y devuelve
     * el objeto modificado. Si no klo encuentra, lanza una excepción.
     * 
     * @param id     el id del recurso que el cliente quiere modificar.
     * @param equipo el recurso con los datos que proporciona el cliente.
     * @return el objeto modificado o RuntimeException si no lo encuentra.
     */

    public Equipo modificarRecurso(Long id, Equipo equipo) {

        // primero buscamos el recurso que corresponde al id proporcionado por el
        // cliente y almacenamos lo que nos devuelve en un contenedor Optional.
        Optional<Equipo> equipoBuscado = equipoRepository.findById(id);

        // si dentro del contenedor había algo, es que el objeto existe
        if (equipoBuscado.isPresent()) {

            // Recuperamos entonces los datos del objeto al que corresponde el id
            Equipo equipoAModificar = equipoBuscado.get();

            // modificamos el nombre del objeto obtenido por el que proporcionó el cliente
            equipoAModificar.setNombre(equipo.getNombre());

            // guardamos los datos en la base de datos y devolvemos el objeto
            return equipoRepository.save(equipoAModificar);

        } else {
            throw new RuntimeException("No se ha encontrado el equipo con el Id especificado.");
        }
    }

    /**
     * Borra / Elimina un recurso de la base de datos. Primero busca si existe
     * el id proporcionado por el cliente. En caso de que sí, procede a borrar el
     * recurso y devuelve un contenedor con dicho recurso. En caso de que no,
     * lanza una excepción.
     * 
     * @param id el id del recurso a borrar, proporcionado por el cliente.
     * @return el recurso si se encontró o RuntimeException.
     */
    public Equipo borrarRecurso(Long id) {

        Optional<Equipo> equipoBuscado = equipoRepository.findById(id);

        // si el recurso existe, lo borra según el id proporcionado
        if (equipoBuscado.isPresent()) {

            Equipo equipoABorrar = equipoBuscado.get();
            equipoRepository.delete(equipoABorrar);

            return equipoABorrar;

            // si no existe, lanza la excepción
        } else {
            throw new RuntimeException("No se ha encontrado el equipo con el Id especificado.");
        }
    }

}
