package edu.universidad.inventario.mapper;

import edu.universidad.inventario.dto.CompraDTO;
import edu.universidad.inventario.dto.DetalleCompraDTO;
import edu.universidad.inventario.entity.Compra;
import edu.universidad.inventario.entity.DetalleCompra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompraMapper {

    @Mapping(target = "proveedorId", source = "proveedor.id")
    @Mapping(target = "detalles", source = "detalles")
    CompraDTO toDTO(Compra compra);

    List<CompraDTO> toDTOList(List<Compra> compras);
    
    // Para mapeo básico sin lógica compleja
    @Mapping(target = "proveedor", ignore = true)
    @Mapping(target = "detalles", ignore = true)
    Compra toEntity(CompraDTO dto);
    
    @Mapping(target = "insumoId", source = "insumo.id")
    DetalleCompraDTO toDetalleDTO(DetalleCompra detalle);
    
    List<DetalleCompraDTO> toDetalleDTOList(List<DetalleCompra> detalles);
}