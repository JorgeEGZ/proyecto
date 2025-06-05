package edu.universidad.inventario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import edu.universidad.inventario.dto.UsuarioDTO;
import edu.universidad.inventario.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UsuarioDTO save(@Valid @RequestBody UsuarioDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

