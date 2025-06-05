package edu.universidad.inventario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import edu.universidad.inventario.dto.AsignaturaDTO;
import edu.universidad.inventario.service.AsignaturaService;


@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AsignaturaController {

    private final AsignaturaService service;

    @GetMapping
    public List<AsignaturaDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public AsignaturaDTO save(@Valid @RequestBody AsignaturaDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public AsignaturaDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

