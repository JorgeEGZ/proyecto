package edu.universidad.inventario.service;

import java.util.List;
import org.springframework.stereotype.Service;
import edu.universidad.inventario.dto.AsignaturaDTO;
import edu.universidad.inventario.mapper.AsignaturaMapper;
import edu.universidad.inventario.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository repository;
    private final AsignaturaMapper mapper;
    


    @Override
    public List<AsignaturaDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public AsignaturaDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
    }

    @Override
    public AsignaturaDTO save(AsignaturaDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
