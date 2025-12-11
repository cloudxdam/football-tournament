package com.dam.api_torneo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("API/api-torneo")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    /**
     * gestiona las peticiones GET llamando al método correspondiente del
     * servicio
     * 
     * @return la lista de todos los jugadores.
     */
    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.getLista();
    }

}
