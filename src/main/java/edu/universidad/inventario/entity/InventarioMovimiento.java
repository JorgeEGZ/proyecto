package edu.universidad.inventario.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario_movimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; 

    private String origen; 

    private Long origenId;

    private BigDecimal cantidad;

    private BigDecimal stockDespues;

    private LocalDateTime fecha;

    @ManyToOne(optional = false)
    private Insumo insumo;
}

