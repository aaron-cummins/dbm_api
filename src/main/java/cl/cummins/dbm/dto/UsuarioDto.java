package cl.cummins.dbm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private Integer usuario;
    private String apellidos;
    private String nombres;
    private String correo_electronico;
    private String e;
    private String u;
    private String current_login;
}
