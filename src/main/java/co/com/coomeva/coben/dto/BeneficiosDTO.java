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
public class BeneficiosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String beneficio;
	private String estado;
	private String etiqueta;
	private Integer idbeneficio;
	private String qr;
	private Integer idcat_CategoriaBeneficio;
	private Integer idprovd_Proveedores;
}
