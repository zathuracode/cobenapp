package co.com.coomeva.coben.domain;

import java.util.Date;

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
@Table(name = "uso_beneficio", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsoBeneficio implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "iduso", unique = true, nullable = false)
	@NotNull
	private Integer iduso;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento")
	@NotNull
	private Asociado asociado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbeneficio")
	@NotNull
	private Beneficios beneficios;
	@Column(name = "fechauso")
	private Date fechauso;
}
