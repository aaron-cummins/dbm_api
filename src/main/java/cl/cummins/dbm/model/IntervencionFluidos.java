package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "intervencion_fluidos")
public class IntervencionFluidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "intervenciones_fluidos_id_seq")
    private Long id;
    private Integer intervencion_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fluido_id")
    private Fluido fluidoId; ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_ingreso")
    private FluidoTipoIngreso tipoIngresoId;

    private Double cantidad;
}
