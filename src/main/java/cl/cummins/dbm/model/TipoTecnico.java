package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tipo_tecnico")
public class TipoTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tipo_tecnico_id_seq")
    private Long id;
    private String nombre;
    private String e;
    private String requerido;
    private String unico;
    private String firma;
}
