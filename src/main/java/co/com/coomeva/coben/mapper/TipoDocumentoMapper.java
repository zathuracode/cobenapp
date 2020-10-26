package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.coomeva.coben.domain.TipoDocumento;
import co.com.coomeva.coben.dto.TipoDocumentoDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface TipoDocumentoMapper {
	public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(TipoDocumento tipoDocumento);

	public TipoDocumento tipoDocumentoDTOToTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO);

	public List<TipoDocumentoDTO> listTipoDocumentoToListTipoDocumentoDTO(List<TipoDocumento> tipoDocumentos);

	public List<TipoDocumento> listTipoDocumentoDTOToListTipoDocumento(List<TipoDocumentoDTO> tipoDocumentoDTOs);
}
