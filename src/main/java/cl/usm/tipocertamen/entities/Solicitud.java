package cl.usm.tipocertamen.entities;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
    private String rut;
    private String nombre;
    private String apellido;
    private String tipoSolicitud;

}
