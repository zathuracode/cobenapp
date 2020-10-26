package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.coomeva.coben.domain.Asociado;
import co.com.coomeva.coben.dto.AsociadoDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface AsociadoMapper {
	@Mapping(source = "tipoDocumento.idtipo", target = "idtipo_TipoDocumento")
	public AsociadoDTO asociadoToAsociadoDTO(Asociado asociado);

	@Mapping(source = "idtipo_TipoDocumento", target = "tipoDocumento.idtipo")
	public Asociado asociadoDTOToAsociado(AsociadoDTO asociadoDTO);

	public List<AsociadoDTO> listAsociadoToListAsociadoDTO(List<Asociado> asociados);

	public List<Asociado> listAsociadoDTOToListAsociado(List<AsociadoDTO> asociadoDTOs);
}
