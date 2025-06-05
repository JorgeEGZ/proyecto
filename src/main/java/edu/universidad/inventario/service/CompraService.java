package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.CompraDTO;

import java.time.LocalDate;
import java.util.List;

public interface CompraService {
    CompraDTO save(CompraDTO dto);
    List<CompraDTO> getAll();
    CompraDTO getById(Long id);
    void delete(Long id);

    List<CompraDTO> getByFechaBetween(LocalDate desde, LocalDate hasta);
}
