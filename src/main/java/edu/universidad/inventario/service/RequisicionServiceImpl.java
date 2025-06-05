package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.RequisicionDTO;

import java.math.BigDecimal;
import java.util.List;

import edu.universidad.inventario.entity.DetalleRequisicion;
import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.entity.Requisicion;
import edu.universidad.inventario.mapper.RequisicionMapper;
import edu.universidad.inventario.repository.InsumoRepository;
import edu.universidad.inventario.repository.RequisicionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisicionServiceImpl implements RequisicionService {

    private final RequisicionRepository repository;
    private final RequisicionMapper mapper;
    private final AuditoriaService auditoriaService;
    private final InsumoRepository insumoRepo;



    @Override
    public RequisicionDTO save(RequisicionDTO dto) {
        Requisicion requisicion = mapper.toEntity(dto);
        for (DetalleRequisicion detalle : requisicion.getDetalles()) {
    Insumo insumo = detalle.getInsumo();
    BigDecimal stockActual = insumo.getStock() != null ? insumo.getStock() : BigDecimal.ZERO;
    BigDecimal cantidadSolicitada = detalle.getCantidadUtilizada();

    if (stockActual.compareTo(cantidadSolicitada) < 0) {
        throw new RuntimeException("Stock insuficiente para el insumo: " + insumo.getNombre());
    }

    // Descontar stock
    insumo.setStock(stockActual.subtract(cantidadSolicitada));
    insumoRepo.save(insumo);
}

        
        auditoriaService.registrar(
            "Requisicion",
            "CREAR",
            requisicion.getId(),
            "Requisición creada para asignatura: " + requisicion.getAsignatura().getNombre()
        );
        return mapper.toDTO(repository.save(requisicion));  
    }

    @Override
    public List<RequisicionDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public RequisicionDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Requisición no encontrada"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
        auditoriaService.registrar(
    "Requisicion",
    "ELIMINAR",
    id,
    "Requisición eliminada"
);
    }
}

