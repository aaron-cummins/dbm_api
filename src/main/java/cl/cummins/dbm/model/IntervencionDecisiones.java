package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "intervencion_decisiones")
public class IntervencionDecisiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "intervencion_decisiones_id_seq")
    private Long id;
    private String folio;
    private String cambio_modulo;
    private String intervencion_terminada;
    private String prueba_potencia_realizada;
    private String prueba_potencia_exitosa;
    private String siguiente_actividad;
    private String reproceso_potencia;
    private String reproceso_modulo;
    private String reproceso_evento;
    private String desconexion_realizada;
    private String desconexion_terminada;
    private String conexion_realizada;
    private String conexion_terminada;
    private String puesta_marcha_realizada;
    private String trabajo_finalizado;
    private String mantencion_terminada;
}
