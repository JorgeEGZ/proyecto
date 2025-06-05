package edu.universidad.inventario.mapper;

import edu.universidad.inventario.dto.DetalleCompraDTO;
import edu.universidad.inventario.entity.DetalleCompra;
import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.repository.InsumoRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DetalleCompraMapper {

    @Autowired
    protected InsumoRepository insumoRepository;

    public DetalleCompraDTO toDTO(DetalleCompra entity) {
        if (entity == null) return null;

        return DetalleCompraDTO.builder()
                .id(entity.getId())
                .insumoId(entity.getInsumo().getId())
                .cantidadComprada(entity.getCantidadComprada())
                .precioUnitario(entity.getPrecioUnitario())
                .fechaVencimiento(entity.getFechaVencimiento())
                .build();
    }

    public DetalleCompra toEntity(DetalleCompraDTO dto) {
        if (dto == null) return null;

        Insumo insumo = insumoRepository.findById(dto.getInsumoId())
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado con ID: " + dto.getInsumoId()));

        return DetalleCompra.builder()
                .id(dto.getId())
                .insumo(insumo)
                .cantidadComprada(dto.getCantidadComprada())
                .precioUnitario(dto.getPrecioUnitario())
                .fechaVencimiento(dto.getFechaVencimiento())
                .build();
    }

    public List<DetalleCompraDTO> toDTOList(List<DetalleCompra> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<DetalleCompra> toEntityList(List<DetalleCompraDTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
