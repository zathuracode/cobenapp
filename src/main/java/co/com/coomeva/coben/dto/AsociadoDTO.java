package co.com.coomeva.coben.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsociadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String apellido;
	private String contrasena;
	private String documento;
	private String imagen;
	private String nickname;
	private String nombre;
	private Integer puntos;
	private String telefono;
	private Integer idtipo_TipoDocumento;
}
