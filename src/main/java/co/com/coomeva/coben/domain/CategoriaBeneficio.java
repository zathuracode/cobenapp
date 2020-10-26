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
@Table(name = "categoria_beneficio", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaBeneficio implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idcat", unique = true, nullable = false)
	@NotNull
	private Integer idcat;

	@Column(name = "categoria")
	private String categoria;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaBeneficio")
	private List<Beneficios> beneficioses = new ArrayList<>();

}