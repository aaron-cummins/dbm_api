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
@Table(name = "sintoma_categoria")
public class CategoriaSintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sintoma_categoria_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private Timestamp updated;
}
