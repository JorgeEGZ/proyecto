package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.RequisicionDTO;
import java.util.List;
import edu.universidad.inventario.entity.Requisicion;
import edu.universidad.inventario.mapper.RequisicionMapper;
import edu.universidad.inventario.repository.RequisicionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisicionServiceImpl implements RequisicionService {

    private final RequisicionRepository repository;
    private final RequisicionMapper mapper;
    private final AuditoriaService auditoriaService;


    @Override
    public RequisicionDTO save(RequisicionDTO dto) {
        Requisicion requisicion = mapper.toEntity(dto);
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

