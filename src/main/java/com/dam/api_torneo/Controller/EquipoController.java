package com.dam.api_torneo.Controller;

import java.util.List;
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
import com.dam.api_torneo.Model.Equipo;
import com.dam.api_torneo.Service.EquipoService;

/**
 * La clase EquipoController es el controlador RESTful.
 * Actúa como puerta de entrada a la API. Expone los endpoints (las URLs) y
 * gestiona las peticiones y respuestas HTTP. Es decir, declara la dirección web
 * específica a la que los clientes externos pueden enviar las peticiones para
 * interactuar con la lógica de negocio. En este caso, la lógica de negocio se
 * delega a la capa de servicio.
 * 
 */

// marcamos la clase como controlador RESTful
@RestController
// indicamos a Spring que todos los endpoints definidos en esta clase deben
// comenzar con el prefijo '/API/api-torneo'
@RequestMapping("/API/api-torneo/equipos")
public class EquipoController {

    // Inyectamos la instancia del servicio que contiene la lógica de negocio.
    @Autowired
    private EquipoService equipoService;

    /**
     * Endpoint que gestiona las peticiones GET llamando al método correspondiente
     * del
     * servicio.
     * 
     * @return la lista de todos los equipos.
     */

    // marcamos así el método para que se ejecute cuando la petición sea de tipo GET
    @GetMapping
    public List<Equipo> getAll() {
        return equipoService.getLista();
    }

    /**
     * Endpoint para buscar un recurso por id.
     * 
     * @param id - el id del recurso que queremos buscar
     * @return el Equipo al que corresponde el id proporcionado + código HTTP
     *         200 (ok) o 404 (not found) si el id especificado no existe.
     */

    // indicamos con esta anotación que este método debe ejecutarse cuando la
    // petición sea de tipo GET con una variable, que en este caso es un id
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getById(@PathVariable Long id) {

        try {
            Equipo equipoBuscado = equipoService.getRecursoPorId(id);
            return ResponseEntity.ok(equipoBuscado);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Endpoint que crea un nuevo recurso a partir de los datos enviados en el
     * cuerpo de la petición del cliente.
     * 
     * @param equipo el objeto recibido en el cuerpo de la petición
     * @return respuesta con código HTTP 201 (creado) y el objeto creado.
     */

    // indicamos que este método debe ejecutarse cuando la petición sea de tipo POST
    @PostMapping
    // indicamos con @RequestBody que en la petición del cliente vienen datos que
    // hay que capturar y convertir a un objeto del tipo especificado
    public ResponseEntity<Equipo> postObject(@RequestBody Equipo equipo) {

        // con el método del servicio guardamos el objeto a partir de los
        // datos recibidos y él se encargará de asignarle automáticamente el id
        Equipo nuevoEquipo = equipoService.crearRecurso(equipo);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }

    /**
     * Endpoint para modificar / actualizar un recurso existente en la base de datos
     * con los nuevos datos proporcionados por el cliente. Solicita la operación a
     * la capa de servicio y responderá con un código HTTP u otro dependiendo de si
     * encuentra o no el recurso.
     * 
     * @param id     el id proporcionado para localizar el recurso en la base de
     *               datos.
     * @param equipo recurso con los nuevos datos.
     * @return respuesta con código HTTP 200 (ok) o 404 (not found) si el id no
     *         se encuentra.
     */

    @PutMapping("/{id}")
    // indicamos con las anotaciones los datos que hay que recibir y procesar
    // @PathVariable indica que en la url está la variable a tener en cuenta.
    public ResponseEntity<Equipo> putObject(@PathVariable Long id, @RequestBody Equipo equipo) {

        try {
            Equipo equipoActualizado = equipoService.modificarRecurso(id, equipo);
            return ResponseEntity.ok(equipoActualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para borrar un recurso de la base de datos según el id especificado
     * por el cliente. Solicita el borrado a la capa de servicio y, según su
     * resultado, proporciona una respuesta con un código HTTP u otro.
     * 
     * @param id el id del recurso a borrar
     * @return respuesta con código HTTP 204 (no content) si se encontró el id y
     *         por tanto se borró el recurso. Si no, devolverá 404 (not found).
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> deleteObject(@PathVariable Long id) {

        try {
            equipoService.borrarRecurso(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
