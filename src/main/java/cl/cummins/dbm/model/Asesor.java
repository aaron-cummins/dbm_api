package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "asesor_tecnico")
public class Asesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "asesor_tecnico_id_seq")
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faena_id", nullable = false)
    private Faena faenaId;

    private String e;
}
