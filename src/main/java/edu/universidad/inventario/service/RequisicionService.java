package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.RequisicionDTO;
import java.util.List;


public interface RequisicionService {
    RequisicionDTO save(RequisicionDTO dto);
    List<RequisicionDTO> getAll();
    RequisicionDTO getById(Long id);
    void delete(Long id);
}

