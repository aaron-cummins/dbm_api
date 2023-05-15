package cl.cummins.dbm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usuario_id_seq")
    private Long id;
    private Integer usuario;
    private String pin;
    private String apellidos;
    private String nombres;
    private String correo_electronico;
    private String e;
    private String u;
    private String current_login;

}
