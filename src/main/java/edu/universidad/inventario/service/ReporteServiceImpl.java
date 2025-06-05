package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.ConsumoInsumoPorAsignaturaDTO;
import edu.universidad.inventario.dto.TopInsumoDTO;

import org.springframework.stereotype.Service;
import edu.universidad.inventario.repository.DetalleRequisicionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final DetalleRequisicionRepository detalleRepo;

    @Override
    public List<ConsumoInsumoPorAsignaturaDTO> getConsumoInsumosPorAsignatura() {
        return detalleRepo.getConsumoInsumosPorAsignatura();
    }

    @Override
public List<TopInsumoDTO> getTopInsumos() {
    return detalleRepo.findTopInsumosMasUsados();
}

}

