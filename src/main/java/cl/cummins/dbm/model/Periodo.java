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
@Table(name = "matriz_periodo")
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "matriz_periodo_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private Timestamp updated;
}
