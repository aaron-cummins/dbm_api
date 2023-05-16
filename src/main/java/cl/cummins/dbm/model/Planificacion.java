package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "planificacion")
public class Planificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "planificacion_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faena_id")
    private Faena faenaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flota_id")
    private  Flota flotaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unidad_id")
    private Unidad unidadId;

    private String esn;
    private String tipointervencion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sintoma_id")
    private Sintoma sintomaId;

    private Integer backlog_id;
    private String observacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;

    private Date fecha;
    private Time hora;
    private Integer estado;
    private Integer trabajoid;
    private Time hora_termino;
    private Date fecha_termino;
    private Timestamp fecha_operacion;
    private String causaraiz;
    private String observacionrevision;
    private Integer cliente;
    private String tipomantencion;
    private String tiempo_trabajo;
    private String lotes_entra;
    private String lotes_sale;
    private String os_sap;
    private String json;
    private String hijo;
    private String padre;
    private String terminado;
    private String tiempo_estimado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aprobador_id")
    private Usuario aprobadorId;

    private Timestamp fecha_aprobacion;
    private String comentario_cliente;
    private Timestamp fecha_registro;
    private Integer alert_mail;
    private String tipointervencion_original;
    private Date fecha_planificacion;
    private Time hora_planificacion;
    private String correlativo;
    private Integer tiempo_dcc;
    private Integer tiempo_oem;
    private Integer tiempo_mina;
    private Timestamp updated;
    private String message_id;
    private String folio;
    private Integer supervisor_responsable;
    private Integer tecnico_principal;
    private Timestamp fecha_guardado;
    private Timestamp fecha_sincronizacion;
    private Integer correlativo_final;
    private Integer reporte_base;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_sintoma_id")
    private SintomaCategoria sintomaCategoriaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motivo_llamado_id")
    private MotivoLlamado motivoLlamadoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turno_id")
    private Turno turnoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "periodo_id")
    private Periodo periodoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lugar_reparacion_id")
    private LugarReparacion lugarReparacionId;

    private Boolean respuesta_continuacion_turno;
    private Double horometro_cabina;
    private Double horometro_motor;
}
