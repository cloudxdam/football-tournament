package com.dam.api_torneo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.api_torneo.Model.Estadio;
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
     * @return el Jugador al que corresponde el id proporcionado o null si no existe
     */

    // anotación de método para petición GET con variable (id)
    @GetMapping("/{id}")
    public Optional<Jugador> getById(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorService.getRecursoPorId(id);

        if (jugador.isPresent()) {
            return Optional.of(jugador.get());
        } else {
            return Optional.empty();
        }
    }

}
