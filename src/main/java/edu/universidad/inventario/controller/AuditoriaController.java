package edu.universidad.inventario.controller;

import edu.universidad.inventario.entity.HistorialMovimiento;
import edu.universidad.inventario.repository.HistorialMovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
@RequiredArgsConstructor
public class AuditoriaController {

    private final HistorialMovimientoRepository repo;

    @GetMapping
    public List<HistorialMovimiento> getAll() {
        return repo.findAll();
    }

    @GetMapping("/usuario/{usuario}")
    public List<HistorialMovimiento> getByUsuario(@PathVariable String usuario) {
        return repo.findByUsuario(usuario);
    }

    @GetMapping("/fecha")
    public List<HistorialMovimiento> getByFecha(@RequestParam String desde, @RequestParam String hasta) {
        return repo.findByFechaBetween(LocalDateTime.parse(desde), LocalDateTime.parse(hasta));
    }
}

