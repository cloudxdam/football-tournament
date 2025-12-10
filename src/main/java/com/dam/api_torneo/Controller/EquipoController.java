package com.dam.api_torneo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam.api_torneo.Model.Equipo;
import com.dam.api_torneo.Service.EquipoService;

/**
 * Puerta de entrada a la API. Expone los endpoints (las URLs) y gestiona
 * las peticiones y respuestas HTTP. No contiene lógica de negocio, solo delega
 * el trabajo a la capa de servicio.
 */

@RestController
@RequestMapping("/API/api-torneo")
public class EquipoController {

    private EquipoService equipoService;

    /**
     * gestiona las peticiones GET llamando al método correspondiente del
     * servicio.
     * 
     * @return la lista de todos los equipos.
     */
    @GetMapping
    public List<Equipo> getAll() {
        return equipoService.getLista();
    }

}
