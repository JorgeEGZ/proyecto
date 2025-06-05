package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.ProveedorDTO;
import java.util.List;  

public interface ProveedorService {
    List<ProveedorDTO> getAll();
    ProveedorDTO getById(Long id);
    ProveedorDTO create(ProveedorDTO dto);
    ProveedorDTO update(Long id, ProveedorDTO dto);
    void delete(Long id);
}

