package edu.universidad.inventario.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleRequisicionDTO {

    private Long id;

    @NotNull
    private Long insumoId;

    @NotNull
    private BigDecimal cantidadUtilizada;

    @NotBlank
    private String unidad;

    @NotNull
    private BigDecimal costoUnitario;

    @NotNull
    private BigDecimal valorTotal;
}

