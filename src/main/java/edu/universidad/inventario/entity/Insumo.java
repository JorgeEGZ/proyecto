package edu.universidad.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insumo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;
    private String unidadMedida;

    @Column(name = "cantidad_stock_actual")
    private Double cantidadStockActual;

    private Double precioPromedio;
}
