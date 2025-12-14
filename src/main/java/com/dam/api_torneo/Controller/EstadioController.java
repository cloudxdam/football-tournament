package com.dam.api_torneo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.api_torneo.Model.Estadio;
import com.dam.api_torneo.Service.EstadioService;

/**
 * Controlador RESTful.
 * Actúa como puerta de entrada a la API. Expone los endpoints (las URLs) y
 * gestiona las peticiones y respuestas HTTP. La lógica de negocio se
 * delega a la capa de servicio.
 * 
 */
@RestController
@RequestMapping("/API/api-torneo/estadios")
public class EstadioController {

    @Autowired
    EstadioService estadioService;

    /**
     * Endpoint que gestiona las peticiones GET llamando al método correspondiente
     * del servicio
     * 
     * @return la lista de todos los estadios.
     */

    @GetMapping
    public List<Estadio> getAll() {

        return estadioService.getLista();
    }

    /**
     * endpoint para buscar un recurso por id
     * 
     * @param id - el id del recurso que queremos buscar
     * @return el Estadio al que corresponde el id proporcionado + código HTTP
     *         200 (ok) o 404 (not found) si el id especificado no existe.
     */

    // anotación de método para petición GET con variable (id)
    @GetMapping("/{id}")
    public ResponseEntity<Estadio> getById(@PathVariable Long id) {

        Optional<Estadio> estadio = estadioService.getRecursoPorId(id);

        if (estadio.isPresent()) {
            return ResponseEntity.of(estadio);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * endpoint que crea un nuevo recurso a partir de los datos enviados en el
     * cuerpo de la petición del cliente.
     * 
     * @param estadio el objeto recibido en el cuerpo de la petición
     * @return respuesta con código HTTP 201 (creado) y el objeto creado.
     */

    @PostMapping
    public ResponseEntity<Estadio> postObject(@RequestBody Estadio estadio) {

        Estadio nuevoEstadio = estadioService.crearRecurso(estadio);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstadio);
    }

    /**
     * Endpoint para modificar / actualizar un recurso existente en la base de datos
     * con los nuevos datos proporcionados por el cliente. Solicita la operación a
     * la capa de servicio, que devuelve un contenedor y, según su contenido
     * responderá con un código HTTP u otro.
     * 
     * @param id      el id proporcionadio para localizar el recurso en la base de
     *                datos.
     * @param estadio recurso con los nuevos datos.
     * @return respuesta con código HTTP 200 (ok) o 404 (not found) si el id no
     *         existe.
     */

    @PutMapping("/{id}")
    // indicamos con las anotaciones los datos que hay que recibir y procesar
    public ResponseEntity<Estadio> putObject(@PathVariable Long id, @RequestBody Estadio estadio) {

        Optional<Estadio> estadioActualizado = estadioService.modificarRecurso(id, estadio);

        if (estadioActualizado.isPresent()) {
            return ResponseEntity.of(estadioActualizado);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para borrar un recurso de la base de datos según el id especificado
     * por el cliente. Solicita el borrado a la capa de servicio, que devuelve un
     * contenedor y, según su contenido, proporcionará una respuesta con un código
     * HTTP
     * u otro.
     * 
     * @param id el id del recurso a borrar
     * @return respuesta con código HTTP 204 (no content) Si se encontró el id y
     *         por tanto se borró el recurso. Si no, devolverá 404 (not found).
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Estadio> deleteObject(@PathVariable Long id) {

        Optional<Estadio> estadioBorrado = estadioService.borrarRecurso(id);

        if (estadioBorrado.isPresent()) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
