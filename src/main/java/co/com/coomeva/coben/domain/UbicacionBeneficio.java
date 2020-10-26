package co.com.coomeva.coben.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ubicacion_beneficio", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionBeneficio implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idub", unique = true, nullable = false)
	@NotNull
	private Integer idub;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbeneficio")
	@NotNull
	private Beneficios beneficios;
	@Column(name = "latitud")
	private String latitud;
	@Column(name = "longitud")
	private String longitud;
}
