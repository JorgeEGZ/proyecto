package edu.universidad.inventario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import edu.universidad.inventario.dto.ConsumoInsumoPorAsignaturaDTO;
import edu.universidad.inventario.dto.TopInsumoDTO;
import edu.universidad.inventario.service.ReporteService;


@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/consumo-insumos")
    public List<ConsumoInsumoPorAsignaturaDTO> getConsumo() {
        return reporteService.getConsumoInsumosPorAsignatura();
    }

    @GetMapping("/top-insumos")
public List<TopInsumoDTO> getTopInsumos() {
    return reporteService.getTopInsumos();
}

}

