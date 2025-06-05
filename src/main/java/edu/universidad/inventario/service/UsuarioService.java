package edu.universidad.inventario.service;

import java.util.List;
import edu.universidad.inventario.dto.UsuarioDTO;


public interface UsuarioService {
    List<UsuarioDTO> getAll();
    UsuarioDTO getById(Long id);
    UsuarioDTO save(UsuarioDTO dto);
    void delete(Long id);
}

