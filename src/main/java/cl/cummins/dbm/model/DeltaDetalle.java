package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "delta_detalle")
public class DeltaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "delta_detalle_id_seq")
    private Long id;
    private String folio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delta_responsable_id", nullable = false)
    private DeltaResponsable deltaResponsableId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delta_item_id", nullable = false)
    private DeltaItem deltaItemId;

    private Integer tiempo;
    private String observacion;
}
