package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.coomeva.coben.domain.Beneficios;
import co.com.coomeva.coben.dto.BeneficiosDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface BeneficiosMapper {
	@Mapping(source = "categoriaBeneficio.idcat", target = "idcat_CategoriaBeneficio")
	@Mapping(source = "proveedores.idprovd", target = "idprovd_Proveedores")
	public BeneficiosDTO beneficiosToBeneficiosDTO(Beneficios beneficios);

	@Mapping(source = "idcat_CategoriaBeneficio", target = "categoriaBeneficio.idcat")
	@Mapping(source = "idprovd_Proveedores", target = "proveedores.idprovd")
	public Beneficios beneficiosDTOToBeneficios(BeneficiosDTO beneficiosDTO);

	public List<BeneficiosDTO> listBeneficiosToListBeneficiosDTO(List<Beneficios> beneficioss);

	public List<Beneficios> listBeneficiosDTOToListBeneficios(List<BeneficiosDTO> beneficiosDTOs);
}
