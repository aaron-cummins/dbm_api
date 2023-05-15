package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tipo_contrato")
public class TipoContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tipo_contrato_id_seq")
    private Long id;
    private String nombre;
    private String e;
}
