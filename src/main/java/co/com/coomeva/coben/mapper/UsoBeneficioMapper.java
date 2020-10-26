package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.coomeva.coben.domain.UsoBeneficio;
import co.com.coomeva.coben.dto.UsoBeneficioDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface UsoBeneficioMapper {
	@Mapping(source = "asociado.documento", target = "documento_Asociado")
	@Mapping(source = "beneficios.idbeneficio", target = "idbeneficio_Beneficios")
	public UsoBeneficioDTO usoBeneficioToUsoBeneficioDTO(UsoBeneficio usoBeneficio);

	@Mapping(source = "documento_Asociado", target = "asociado.documento")
	@Mapping(source = "idbeneficio_Beneficios", target = "beneficios.idbeneficio")
	public UsoBeneficio usoBeneficioDTOToUsoBeneficio(UsoBeneficioDTO usoBeneficioDTO);

	public List<UsoBeneficioDTO> listUsoBeneficioToListUsoBeneficioDTO(List<UsoBeneficio> usoBeneficios);

	public List<UsoBeneficio> listUsoBeneficioDTOToListUsoBeneficio(List<UsoBeneficioDTO> usoBeneficioDTOs);
}
