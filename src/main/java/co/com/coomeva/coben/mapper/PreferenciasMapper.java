package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.coomeva.coben.domain.Preferencias;
import co.com.coomeva.coben.dto.PreferenciasDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface PreferenciasMapper {
	@Mapping(source = "asociado.documento", target = "documento_Asociado")
	@Mapping(source = "beneficios.idbeneficio", target = "idbeneficio_Beneficios")
	public PreferenciasDTO preferenciasToPreferenciasDTO(Preferencias preferencias);

	@Mapping(source = "documento_Asociado", target = "asociado.documento")
	@Mapping(source = "idbeneficio_Beneficios", target = "beneficios.idbeneficio")
	public Preferencias preferenciasDTOToPreferencias(PreferenciasDTO preferenciasDTO);

	public List<PreferenciasDTO> listPreferenciasToListPreferenciasDTO(List<Preferencias> preferenciass);

	public List<Preferencias> listPreferenciasDTOToListPreferencias(List<PreferenciasDTO> preferenciasDTOs);
}
