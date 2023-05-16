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
@Table(name = "motivo_llamado")
public class MotivoLlamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "motivo_llamado_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private Timestamp updated;
}
