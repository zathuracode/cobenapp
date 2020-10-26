package co.com.coomeva.coben.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.coomeva.coben.domain.Proveedores;
import co.com.coomeva.coben.dto.ProveedoresDTO;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface ProveedoresMapper {
	public ProveedoresDTO proveedoresToProveedoresDTO(Proveedores proveedores);

	public Proveedores proveedoresDTOToProveedores(ProveedoresDTO proveedoresDTO);

	public List<ProveedoresDTO> listProveedoresToListProveedoresDTO(List<Proveedores> proveedoress);

	public List<Proveedores> listProveedoresDTOToListProveedores(List<ProveedoresDTO> proveedoresDTOs);
}
