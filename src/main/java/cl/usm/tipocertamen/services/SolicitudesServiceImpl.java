package cl.usm.tipocertamen.services;


import cl.usm.tipocertamen.entities.Solicitud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class SolicitudesServiceImpl implements SolicitudesService{

    private static List<Solicitud> solicitudes = new ArrayList<>();
    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);

        return solicitud;
    }

    @Override
    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    @Override
    public List<Solicitud> filtrarSolicitudes(String tipoSolicitud) {
        return solicitudes.stream()
                .filter(s -> s.getTipoSolicitud().equalsIgnoreCase(tipoSolicitud))
                .collect(Collectors.toList());
    }
}
