package edu.universidad.inventario.mapper;

import edu.universidad.inventario.dto.CompraDTO;
import edu.universidad.inventario.dto.DetalleCompraDTO;
import edu.universidad.inventario.entity.Compra;
import edu.universidad.inventario.entity.DetalleCompra;
import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.entity.Proveedor;
import edu.universidad.inventario.repository.InsumoRepository;
import edu.universidad.inventario.repository.ProveedorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.List;
import org.mapstruct.ReportingPolicy;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CompraMapper {

    @Autowired
    protected ProveedorRepository proveedorRepository;

    @Autowired
    protected InsumoRepository insumoRepository;

    @Mapping(target = "proveedorId", source = "proveedor.id")
    @Mapping(target = "detalles", expression = "java(toDetalleCompraDTOList(compra.getDetalles()))")
    public abstract CompraDTO toDTO(Compra compra);

    public abstract List<CompraDTO> toDTOList(List<Compra> compras);

    public Compra toEntity(CompraDTO dto) {
        if (dto == null) return null;

        Compra compra = new Compra();
        compra.setId(dto.getId());
        compra.setFechaCompra(dto.getFechaCompra());
        compra.setNumeroFactura(dto.getNumeroFactura());
        compra.setEstado(dto.getEstado());
        compra.setTotalCompra(dto.getTotalCompra());

        // Asignar proveedor
        Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        compra.setProveedor(proveedor);

        // Asignar detalles
        List<DetalleCompra> detalles = dto.getDetalles().stream().map(detalleDTO -> {
            Insumo insumo = insumoRepository.findById(detalleDTO.getInsumoId())
                    .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));

            return DetalleCompra.builder()
                    .id(detalleDTO.getId())
                    .insumo(insumo)
                    .cantidadComprada(detalleDTO.getCantidadComprada())
                    .precioUnitario(detalleDTO.getPrecioUnitario())
                    .fechaVencimiento(detalleDTO.getFechaVencimiento())
                    .compra(compra) // importante para la relación bidireccional
                    .build();
        }).collect(Collectors.toList());

        compra.setDetalles(detalles);

        return compra;
    }

    public List<DetalleCompraDTO> toDetalleCompraDTOList(List<DetalleCompra> detalleList) {
        if (detalleList == null) return null;

        return detalleList.stream().map(detalle -> DetalleCompraDTO.builder()
                .id(detalle.getId())
                .insumoId(detalle.getInsumo().getId())
                .cantidadComprada(detalle.getCantidadComprada())
                .precioUnitario(detalle.getPrecioUnitario())
                .fechaVencimiento(detalle.getFechaVencimiento())
                .build()).collect(Collectors.toList());
    }
}

