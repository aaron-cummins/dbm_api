package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "faena")
public class Faena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "faena_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private String codigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zona_id", nullable = false)
    private FaenaZona zonaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zona_numerica_id", nullable = false)
    private FaenaZonaNumerica zonaNumericaId;

    private Integer altura;

}
