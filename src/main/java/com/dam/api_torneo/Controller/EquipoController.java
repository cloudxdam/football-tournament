package com.dam.api_torneo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * gestiona las peticiones GET llamando al método correspondiente del
     * servicio.
     * 
     * @return la lista de todos los equipos.
     */

    // marcamos así el método para que se ejecute cuando la petición sea de tipo GET
    @GetMapping
    public List<Equipo> getAll() {
        return equipoService.getLista();
    }

}
