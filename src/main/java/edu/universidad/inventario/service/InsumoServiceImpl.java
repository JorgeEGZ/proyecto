package edu.universidad.inventario.service;

import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.repository.InsumoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor 
public class InsumoServiceImpl implements InsumoService {

    private final InsumoRepository insumoRepository;

    @Override
    public List<Insumo> findAll() {
        return insumoRepository.findAll();
    }

    @Override
    public Insumo findById(Long id) {
        return insumoRepository.findById(id).orElse(null);
    }

    @Override
    public Insumo save(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    @Override
    public void delete(Long id) {
        insumoRepository.deleteById(id);
    }
}