package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "lugar_creacion")
public class LugarCreacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "lugar_creacion_id_seq")
    private Long id;
    private String nombre;
}
