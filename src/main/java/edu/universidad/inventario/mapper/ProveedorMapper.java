package edu.universidad.inventario.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import edu.universidad.inventario.dto.ProveedorDTO;
import edu.universidad.inventario.entity.Proveedor;
    


@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    ProveedorDTO toDTO(Proveedor proveedor);
    Proveedor toEntity(ProveedorDTO dto);

    List<ProveedorDTO> toDTOList(List<Proveedor> proveedores);
}
