package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "estado_equipos")
public class EstadoEquipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "estados_equipo_id_seq")
    private Long id;
    private String nombre;
}
