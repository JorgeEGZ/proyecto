package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.ConsumoInsumoPorAsignaturaDTO;
import edu.universidad.inventario.dto.TopInsumoDTO;

import java.util.List;

public interface ReporteService {
    List<ConsumoInsumoPorAsignaturaDTO> getConsumoInsumosPorAsignatura();
    
    List<TopInsumoDTO> getTopInsumos();
}

