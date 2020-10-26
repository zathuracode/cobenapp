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
public class ProveedoresDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idprovd;
	private String imagen;
	private String proveedor;
}
