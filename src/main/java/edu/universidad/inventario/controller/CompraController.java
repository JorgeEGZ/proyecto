package edu.universidad.inventario.controller;

import edu.universidad.inventario.dto.CompraDTO;
import edu.universidad.inventario.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompraController {

    private final CompraService compraService;

    @GetMapping
    public List<CompraDTO> getAll() {
        return compraService.getAll();
    }

    @PostMapping
    public CompraDTO save(@Valid @RequestBody CompraDTO dto) {
        return compraService.save(dto);
    }

    @GetMapping("/{id}")
    public CompraDTO getById(@PathVariable Long id) {
        return compraService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        compraService.delete(id);
    }   

    @GetMapping("/fecha")
public List<CompraDTO> getByFecha(@RequestParam String desde, @RequestParam String hasta) {
    LocalDate fechaDesde = LocalDate.parse(desde);
    LocalDate fechaHasta = LocalDate.parse(hasta);
    return compraService.getByFechaBetween(fechaDesde, fechaHasta);
}

}

