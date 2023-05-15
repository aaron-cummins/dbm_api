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
@Table(name = "motor")
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "motor_id_seq")
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_emision_id")
    private TipoEmision tipoEmisionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_admision_id")
    private TipoAdmision tipoAdmisionId;

    private String e;
    private Timestamp updated;
}
