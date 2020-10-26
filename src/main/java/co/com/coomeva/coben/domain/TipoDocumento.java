package co.com.coomeva.coben.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */
@Entity
@Table(name = "tipo_documento", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idtipo", unique = true, nullable = false)
	@NotNull
	private Integer idtipo;

	@Column(name = "tipo")
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocumento")
	private List<Asociado> asociados = new ArrayList<>();

}