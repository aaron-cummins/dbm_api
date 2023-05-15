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
@Table(name = "sintoma")
public class Sintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sintoma_id_seq")
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sintoma_categoria_id")
    private SintomaCategoria sintomaCategoriaId;

    private Integer codigo;
    private String e;
    private Timestamp updated;
}
