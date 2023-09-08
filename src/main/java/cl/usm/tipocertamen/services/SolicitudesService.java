package cl.usm.tipocertamen.services;

import cl.usm.tipocertamen.entities.Solicitud;

import java.util.List;

public interface SolicitudesService {

    Solicitud crearSolicitud(Solicitud solicitud);

    List<Solicitud> getSolicitudes();

    List<Solicitud> filtrarSolicitudes(String tipoSolicitud);
}
