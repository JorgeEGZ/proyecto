package edu.universidad.inventario.service;

import java.util.List;
import edu.universidad.inventario.dto.AsignaturaDTO;


public interface AsignaturaService {
    List<AsignaturaDTO> getAll();
    AsignaturaDTO getById(Long id);
    AsignaturaDTO save(AsignaturaDTO dto);
    void delete(Long id);
}

