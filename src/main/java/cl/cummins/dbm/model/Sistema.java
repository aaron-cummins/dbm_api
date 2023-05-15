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
@Table(name = "sistema")
public class Sistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sistema_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private Timestamp updated;
}
