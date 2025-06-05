package edu.universidad.inventario.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.entity.InventarioMovimiento;
import edu.universidad.inventario.repository.InventarioMovimientoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioMovimientoServiceImpl implements InventarioMovimientoService {

    private final InventarioMovimientoRepository repo;

    @Override
    public void registrarMovimiento(String tipo, String origen, Long origenId, Insumo insumo, BigDecimal cantidad) {
        BigDecimal stockActual = insumo.getStock() != null ? insumo.getStock() : BigDecimal.ZERO;

        InventarioMovimiento mov = InventarioMovimiento.builder()
                .tipo(tipo)
                .origen(origen)
                .origenId(origenId)
                .cantidad(cantidad)
                .stockDespues(stockActual)
                .insumo(insumo)
                .fecha(LocalDateTime.now())
                .build();

        repo.save(mov);
    }
}

