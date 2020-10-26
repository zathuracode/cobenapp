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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */
@Entity
@Table(name = "asociado", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asociado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "documento", unique = true, nullable = false)
	@NotNull
	private String documento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipo")
	@NotNull
	private TipoDocumento tipoDocumento;

	@Column(name = "apellido")
	private String apellido;
	@Column(name = "contrasena")
	private String contrasena;
	@Column(name = "imagen")
	private String imagen;
	@NotNull
	@NotEmpty
	@Size(max = 20)
	@Column(name = "nickname", nullable = false)
	private String nickname;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "puntos")
	private Integer puntos;
	@Column(name = "telefono")
	private String telefono;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asociado")
	private List<Preferencias> preferenciases = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asociado")
	private List<UsoBeneficio> usoBeneficios = new ArrayList<>();

}