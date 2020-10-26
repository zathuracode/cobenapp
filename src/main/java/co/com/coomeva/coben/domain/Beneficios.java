package co.com.coomeva.coben.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "beneficios", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beneficios implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idbeneficio", unique = true, nullable = false)
	@NotNull
	private Integer idbeneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcat")
	@NotNull
	private CategoriaBeneficio categoriaBeneficio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprovd")
	@NotNull
	private Proveedores proveedores;

	@Column(name = "beneficio")
	private String beneficio;
	@Column(name = "estado")
	private String estado;
	@Column(name = "etiqueta")
	private String etiqueta;
	@Column(name = "qr")
	private String qr;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficios")
	private List<Preferencias> preferenciases = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficios")
	private List<UbicacionBeneficio> ubicacionBeneficios = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficios")
	private List<UsoBeneficio> usoBeneficios = new ArrayList<>();

}