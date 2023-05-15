package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "delta_responsable")
public class DeltaResponsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "delta_responsable_id_seq")
    private Long id;
    private String nombre;
}
