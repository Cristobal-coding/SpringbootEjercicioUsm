package cl.usm.tipocertamen.controllers;

import cl.usm.tipocertamen.entities.Solicitud;
import cl.usm.tipocertamen.services.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudesService solicitudesService;
    private boolean isTipoValido (String tipoSolicitud){
        String [] tipos = {"SolicitudCedula","RetiroCedula","SolicitudCertificadoNac","SolicitudCertificadoDef"};
        return Stream.of(tipos).anyMatch(t->t.equalsIgnoreCase(tipoSolicitud));

    };

    @GetMapping("/verSolicitudes/{tipoSolicitud}")
    public  ResponseEntity<List<Solicitud>> filtrarSolicitudes(@PathVariable String tipoSolicitud){
        try {
            return ResponseEntity.ok(this.solicitudesService.filtrarSolicitudes(tipoSolicitud));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/verSolicitudes")
    public ResponseEntity<List<Solicitud>> getSolicitudes(){
        try{
            return ResponseEntity.ok(this.solicitudesService.getSolicitudes());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    };

    @PostMapping("/ingresarSolicitud")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud){

        if(!isTipoValido(solicitud.getTipoSolicitud())){
            return ResponseEntity.badRequest().build();
        }
        try {
            Solicitud newSolicitud = solicitudesService.crearSolicitud(solicitud);
            return ResponseEntity.ok(newSolicitud);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    };
}
