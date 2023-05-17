package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "intervencion_comentarios")
public class IntervencionComentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "intervencion_comentarios_id_seq")
    private Long id;
    private String folio;
    private String planificacion;
    private String comentario;
    private String codigo_kch;

}
