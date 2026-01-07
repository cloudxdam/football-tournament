package com.dam.api_torneo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dam.api_torneo.Model.Jugador;
import com.dam.api_torneo.Service.JugadorService;

/**
 * Controlador RESTful. Actúa como puerta de entrada a la API. Expone los
 * endpoints (las URLs) y gestiona las peticiones y respuestas HTTP. La lógica
 * de negocio se delega a la capa de servicio.
 *
 */
@RestController
@RequestMapping("API/api-torneo/jugadores")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    /**
     * Endpoint que gestiona las peticiones GET llamando al método
     * correspondiente del servicio
     *
     * @return la lista de todos los jugadores.
     */
    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.getLista();
    }

    /**
     * endpoint para buscar un recurso por id
     *
     * @param id - el id del recurso que queremos buscar
     * @return el Jugador al que corresponde el id proporcionado + código HTTP
     *         200 (ok) o 404 (not found) si el id especificado no existe.
     */
    // anotación de método para petición GET con variable (id)
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Long id) {

        Optional<Jugador> jugador = jugadorService.getRecursoPorId(id);

        if (jugador.isPresent()) {
            return ResponseEntity.of(jugador);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * endpoint que crea un nuevo recurso a partir de los datos enviados en el
     * cuerpo de la petición del cliente.
     *
     * @param jugador el objeto recibido en el cuerpo de la petición
     * @return respuesta con código HTTP 201 (creado) y el objeto creado o 409
     *         Conflict en caso de que ya exista el nif especificado en la base de
     *         datos.
     */
    @PostMapping
    public ResponseEntity<Jugador> postObject(@RequestBody Jugador jugador) {

        Optional<Jugador> jugadorBuscado = jugadorService.crearRecurso(jugador);

        if (jugadorBuscado.isPresent()) {
            Jugador nuevoJugador = jugadorBuscado.get();
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoJugador);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * Endpoint para modificar / actualizar un recurso existente en la base de
     * datos con los nuevos datos proporcionados por el cliente. Solicita la
     * operación a la capa de servicio, que devuelve un contenedor y, según su
     * contenido responderá con un código HTTP u otro.
     *
     * @param id      el id proporcionadio para localizar el recurso en la base de
     *                datos.
     * @param jugador recurso con los nuevos datos.
     * @return respuesta con código HTTP 200 (ok) o 404 (not found) si el id no
     *         existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Jugador> putObject(@PathVariable Long id, @RequestBody Jugador jugador) {
        Optional<Jugador> jugadorActualizado = jugadorService.modificarRecurso(id, jugador);

        if (jugadorActualizado.isPresent()) {
            return ResponseEntity.of(jugadorActualizado);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para borrar un recurso de la base de datos según el id
     * especificado por el cliente. Solicita el borrado a la capa de servicio,
     * que devuelve un contenedor y, según su contenido, proporcionará una
     * respuesta con un código HTTP u otro.
     *
     * @param id el id del recurso a borrar
     * @return respuesta con código HTTP 204 (no content) Si se encontró el id y
     *         por tanto se borró el recurso. Si no, devolverá 404 (not found).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Jugador> deleteObject(@PathVariable Long id) {

        Optional<Jugador> jugadorBorrado = jugadorService.borrarRecurso(id);

        if (jugadorBorrado.isPresent()) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Búsqueda compuesta. Realiza una búsqueda por parámetros.
     *
     * @param nombre    el nombre del jugador
     * @param apellidos apellidos del jugador
     * @return lista con los jugadores coincidentes encontrados o respuesta 204
     *         No Content.
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Jugador>> getCompound(@RequestParam String nombre, @RequestParam String apellidos) {

        List<Jugador> jugadoresEncontrados = jugadorService.buscarConParametros(nombre, apellidos);

        if (!jugadoresEncontrados.isEmpty()) {
            return ResponseEntity.ok(jugadorService.buscarConParametros(nombre, apellidos));

        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // modificación 2.1 operación en lote
    @PostMapping("/lote")
    public ResponseEntity<List<Jugador>> postBatch(@RequestBody List<Jugador> jugadores) {
        // TODO puntos 3 y 4 y javadoc

        try {
            List<Jugador> jugadoresGuardados = jugadorService.saveAll(jugadores);
            return ResponseEntity.status(HttpStatus.CREATED).body(jugadoresGuardados);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
