package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "delta_item")
public class DeltaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "delta_item_id_seq")
    private Long id;
    private Integer grupo;
    private String nombre;
}
