package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.coomeva.coben.domain.CategoriaBeneficio;
import co.com.coomeva.coben.dto.CategoriaBeneficioDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface CategoriaBeneficioMapper {
	public CategoriaBeneficioDTO categoriaBeneficioToCategoriaBeneficioDTO(CategoriaBeneficio categoriaBeneficio);

	public CategoriaBeneficio categoriaBeneficioDTOToCategoriaBeneficio(CategoriaBeneficioDTO categoriaBeneficioDTO);

	public List<CategoriaBeneficioDTO> listCategoriaBeneficioToListCategoriaBeneficioDTO(
			List<CategoriaBeneficio> categoriaBeneficios);

	public List<CategoriaBeneficio> listCategoriaBeneficioDTOToListCategoriaBeneficio(
			List<CategoriaBeneficioDTO> categoriaBeneficioDTOs);
}
