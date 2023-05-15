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
@Table(name = "criticidad")
public class Criticidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "criticidad_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private Timestamp updated;
}
