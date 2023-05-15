package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "faena_flota")
public class FaenaFlota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "faena_flota_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faena_id", nullable = false)
    private Faena faenaId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flota_id")
    private Flota flotaId;


    private Integer motor_id;

    private String e;
}
