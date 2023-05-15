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
@Table(name = "faena_zona_numerica")
public class FaenaZonaNumerica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "faena_zona_numerica_id_seq")
    private Long id;
    private String nombre;
    private String e;

}
