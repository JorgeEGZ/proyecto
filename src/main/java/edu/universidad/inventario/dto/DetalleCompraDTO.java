package edu.universidad.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleCompraDTO {

    private Long id;

    @NotNull(message = "El ID del insumo es obligatorio")
    private Long insumoId;

    @NotNull(message = "La cantidad comprada es obligatoria")
    @Positive(message = "La cantidad comprada debe ser mayor a 0")
    private BigDecimal cantidadComprada;

    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio unitario debe ser mayor a 0")
    private BigDecimal precioUnitario;

    private LocalDate fechaVencimiento;
}
