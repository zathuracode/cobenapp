package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.coomeva.coben.domain.UbicacionBeneficio;
import co.com.coomeva.coben.dto.UbicacionBeneficioDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface UbicacionBeneficioMapper {
	@Mapping(source = "beneficios.idbeneficio", target = "idbeneficio_Beneficios")
	public UbicacionBeneficioDTO ubicacionBeneficioToUbicacionBeneficioDTO(UbicacionBeneficio ubicacionBeneficio);

	@Mapping(source = "idbeneficio_Beneficios", target = "beneficios.idbeneficio")
	public UbicacionBeneficio ubicacionBeneficioDTOToUbicacionBeneficio(UbicacionBeneficioDTO ubicacionBeneficioDTO);

	public List<UbicacionBeneficioDTO> listUbicacionBeneficioToListUbicacionBeneficioDTO(
			List<UbicacionBeneficio> ubicacionBeneficios);

	public List<UbicacionBeneficio> listUbicacionBeneficioDTOToListUbicacionBeneficio(
			List<UbicacionBeneficioDTO> ubicacionBeneficioDTOs);
}
