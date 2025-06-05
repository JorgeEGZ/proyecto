package edu.universidad.inventario.controller;

import edu.universidad.inventario.dto.RequisicionDTO;
import edu.universidad.inventario.service.RequisicionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/requisiciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequisicionController {

    private final RequisicionService service;

    @GetMapping
    public List<RequisicionDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public RequisicionDTO create(@Valid @RequestBody RequisicionDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public RequisicionDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

