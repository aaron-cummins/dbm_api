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
@Table(name = "unidad")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "unidad_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faena_id", nullable = true)
    private Faena faenaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flota_id", nullable = true)
    private Flota flotaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motor_id", nullable = true)
    private Motor motorId;

    private String unidad;
    private Double horometro;
    private String esn;
    private String aplicacion;
    private String nserie;
    private String modelo_equipo;
    private String modelo_motor;
    private String ninterno;
    private String fabricante;
    private String e;
    private Timestamp updated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_equipo_id", nullable = false)
    private EstadoEquipos estadoEquiposId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_motor_id", nullable = false)
    private EstadoMotor estadoMotorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_contrato_id", nullable = false)
    private TipoContrato tipoContratoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aprobador_id", nullable = true)
    private Usuario aprobadorId;

    private Double avance_teorico;
}
