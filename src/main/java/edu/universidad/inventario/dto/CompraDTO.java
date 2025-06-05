package edu.universidad.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraDTO {

    private Long id;

    @NotNull(message = "El ID del proveedor es obligatorio")
    private Long proveedorId;

    @NotBlank(message = "El número de factura es obligatorio")
    private String numeroFactura;

    private String estado;

    private LocalDate fechaCompra;

    private BigDecimal totalCompra;

    @NotEmpty(message = "Debe contener al menos un detalle de compra")
    private List<DetalleCompraDTO> detalles;
}
