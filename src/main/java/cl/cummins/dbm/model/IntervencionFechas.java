package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "intervencion_fechas")
public class IntervencionFechas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "intervencion_fechas_id_seq")
    private Long id;
    private String folio;
    private Timestamp planificada;
    private Timestamp llamado;
    private Timestamp llegada;
    private Timestamp inicio_intervencion;
    private Timestamp termino_intervencion;
    private Timestamp inicio_prueba_potencia;
    private Timestamp termino_prueba_potencia;
    private Timestamp inicio_desconexion;
    private Timestamp termino_desconexion;
    private Timestamp inicio_conexion;
    private Timestamp termino_conexion;
    private Timestamp inicio_puesta_marcha;
    private Timestamp termino_puesta_marcha;
    private Timestamp termino_reproceso;
    private Timestamp fecha_termino_global;
    private Timestamp fecha_inicio_global;
    private Timestamp fecha_inicio_delta;
    private Timestamp fecha_termino_turno;
}
