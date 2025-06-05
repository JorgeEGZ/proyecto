package edu.universidad.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignaturaDTO {

    private Long id;

    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    private String nombre;

    @NotBlank(message = "El nombre del docente es obligatorio")
    private String docente;

    private String codigo;
}

