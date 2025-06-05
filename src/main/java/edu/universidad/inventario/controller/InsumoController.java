package edu.universidad.inventario.controller;


import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.service.InsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insumos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InsumoController {

    private final InsumoService service;

    @GetMapping
    public List<Insumo> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Insumo save(@RequestBody Insumo insumo) {
        return service.save(insumo);
    }

    @GetMapping("/{id}")
    public Insumo getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


