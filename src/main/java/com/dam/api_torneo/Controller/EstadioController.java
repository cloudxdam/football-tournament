package com.dam.api_torneo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * gestiona las peticiones GET llamando al método correspondiente del
     * servicio
     * 
     * @return la lista de todos los estadios.
     */

    @GetMapping
    public List<Estadio> getAll() {
        return estadioService.getLista();
    }

}
