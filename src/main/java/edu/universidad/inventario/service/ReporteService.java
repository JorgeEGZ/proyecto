package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.ConsumoInsumoPorAsignaturaDTO;
import java.util.List;

public interface ReporteService {
    List<ConsumoInsumoPorAsignaturaDTO> getConsumoInsumosPorAsignatura();
}

