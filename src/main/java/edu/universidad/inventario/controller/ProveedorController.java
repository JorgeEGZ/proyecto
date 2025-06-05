package edu.universidad.inventario.controller;

import edu.universidad.inventario.dto.ProveedorDTO;
import edu.universidad.inventario.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class ProveedorController {

    private final ProveedorService service;

    @GetMapping
    public List<ProveedorDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProveedorDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProveedorDTO create(@Valid @RequestBody ProveedorDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ProveedorDTO update(@PathVariable Long id, @Valid @RequestBody ProveedorDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

