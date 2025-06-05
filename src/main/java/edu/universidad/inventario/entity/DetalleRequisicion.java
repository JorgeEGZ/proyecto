package edu.universidad.inventario.entity;

import edu.universidad.inventario.entity.DetalleRequisicion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Entity
@Table(name = "detalle_requisicion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleRequisicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "requisicion_id")
    private Requisicion requisicion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    private BigDecimal cantidadUtilizada;

    private String unidad;

    private BigDecimal costoUnitario;

    private BigDecimal valorTotal;
}

