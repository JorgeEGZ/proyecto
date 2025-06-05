package edu.universidad.inventario.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequisicionDTO {

    private Long id;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private Integer numeroEstudiantes;

    @NotNull
    private Long asignaturaId;

    @NotNull
    private Long usuarioId;

    @NotEmpty
    private List<DetalleRequisicionDTO> detalles;
}

