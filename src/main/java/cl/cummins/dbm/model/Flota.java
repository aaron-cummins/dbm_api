package cl.cummins.dbm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "flota")
public class Flota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "faena_id_seq")
    private Long id;
    private String nombre;
    private String e;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "faena_id", nullable = false)
    @Column(nullable = true)
    private Integer faena_id;

    private String aplicacion;
    private String oem;
}
