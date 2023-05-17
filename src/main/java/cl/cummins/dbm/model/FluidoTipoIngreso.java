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
@Table(name = "matriz_fluidos_unidad")
public class FluidoTipoIngreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "matriz_fluidos_tipo_ingreso_id_seq")
    private Long id;
    private String nombre;
    private Character e;
    private Timestamp updated;
}
