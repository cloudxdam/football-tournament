package com.dam.api_torneo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.api_torneo.Model.Jugador;
import com.dam.api_torneo.Service.JugadorService;

/**
 * Controlador RESTful.
 * Actúa como puerta de entrada a la API. Expone los endpoints (las URLs) y
 * gestiona las peticiones y respuestas HTTP. La lógica de negocio se
 * delega a la capa de servicio.
 * 
 */
@RestController
@RequestMapping("API/api-torneo/jugadores")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    /**
     * Endpoint que gestiona las peticiones GET llamando al método correspondiente
     * del servicio
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
     * @return respuesta con código HTTP 201 (creado) y el objeto creado.
     */

    @PostMapping
    public ResponseEntity<Jugador> postObject(@RequestBody Jugador jugador) {
        Jugador nuevoJugador = jugadorService.crearObjeto(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoJugador);
    }

    /**
     * Endpoint para modificar / actualizar un recurso existente en la base de datos
     * con los nuevos datos proporcionados por el cliente.
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

}
