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
@Table(name = "matriz_fluidos")
public class Fluido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "matriz_fluidos_id_seq")
    private Long id;
    private String nombre;


    private Integer tipo_ingreso_id;

    private Character e;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unidad_id")
    private FluidoUnidad unidadId;

    private Timestamp updated;
}
