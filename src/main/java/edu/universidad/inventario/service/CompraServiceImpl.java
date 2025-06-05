package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.CompraDTO;
import edu.universidad.inventario.entity.Compra;
import edu.universidad.inventario.entity.DetalleCompra;
import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.entity.Proveedor;
import edu.universidad.inventario.mapper.CompraMapper;
import edu.universidad.inventario.repository.CompraRepository;
import edu.universidad.inventario.repository.InsumoRepository;
import edu.universidad.inventario.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepo;
    private final ProveedorRepository proveedorRepo;
    private final InsumoRepository insumoRepo;
    private final CompraMapper compraMapper;
    private final AuditoriaService auditoriaService; 
    private final InventarioMovimientoService inventarioMovimientoService;

    @Override
    public CompraDTO save(CompraDTO dto) {
        Proveedor proveedor = proveedorRepo.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    
        Compra compra = compraMapper.toEntity(dto);
        compra.setProveedor(proveedor);
        compra.setFechaCompra(LocalDate.now());
    
        for (DetalleCompra detalle : compra.getDetalles()) {
            detalle.setCompra(compra);
            detalle.setInsumo(insumoRepo.findById(detalle.getInsumo().getId())
                    .orElseThrow(() -> new RuntimeException("Insumo no encontrado")));
        }
    
        compra = compraRepo.save(compra);
    
        // Actualizar stock e insertar movimiento para cada detalle de compra
        for (DetalleCompra detalle : compra.getDetalles()) {
            Insumo insumo = detalle.getInsumo();
            BigDecimal cantidadActual = insumo.getStock() != null ? insumo.getStock() : BigDecimal.ZERO;
            insumo.setStock(cantidadActual.add(detalle.getCantidadComprada()));
            insumoRepo.save(insumo);
    
            // Registrar movimiento en inventario
            inventarioMovimientoService.registrarMovimiento(
                "ENTRADA",
                "COMPRA",
                compra.getId(),
                insumo,
                detalle.getCantidadComprada()
            );
        }
    
        auditoriaService.registrar(
                "Compra",
                "CREAR",
                compra.getId(),
                "Compra registrada con proveedor: " + proveedor.getNombre()
        );
    
        return compraMapper.toDTO(compra);
    }
    

    @Override
    public List<CompraDTO> getAll() {
        return compraMapper.toDTOList(compraRepo.findAll());
    }

    @Override
    public CompraDTO getById(Long id) {
        return compraRepo.findById(id)
                .map(compraMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
    }

    @Override
    public void delete(Long id) {
        compraRepo.deleteById(id);

        auditoriaService.registrar(
                "Compra",
                "ELIMINAR",
                id,
                "Compra eliminada"
        );
    }

    public List<CompraDTO> getByFechaBetween(LocalDate desde, LocalDate hasta) {
        List<Compra> compras = compraRepo.findByFechaCompraBetween(desde, hasta);
        return compraMapper.toDTOList(compras);
    }
}

