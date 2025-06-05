package edu.universidad.inventario.service;

import java.math.BigDecimal;
import edu.universidad.inventario.entity.Insumo;

public interface InventarioMovimientoService {
    void registrarMovimiento(String tipo, String origen, Long origenId, Insumo insumo, BigDecimal cantidad);
}

