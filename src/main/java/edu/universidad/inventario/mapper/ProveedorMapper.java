package edu.universidad.inventario.mapper;

import edu.universidad.inventario.dto.ProveedorDTO;
import edu.universidad.inventario.entity.Proveedor;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    ProveedorDTO toDTO(Proveedor proveedor);
    Proveedor toEntity(ProveedorDTO dto);

    List<ProveedorDTO> toDTOList(List<Proveedor> proveedores);
}
