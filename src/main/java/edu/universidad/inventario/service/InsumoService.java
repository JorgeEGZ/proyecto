package edu.universidad.inventario.service;

import edu.universidad.inventario.entity.Insumo;
import java.util.List;


public interface InsumoService {
    List<Insumo> findAll();
    Insumo save(Insumo insumo);
    void delete(Long id);
    Insumo findById(Long id);
}
