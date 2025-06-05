package edu.universidad.inventario.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;


@Entity
@Table(name = "historial_movimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entidad;

    private String accion;

    private Long entidadId;

    private String usuario;

    private LocalDateTime fecha;

    private String descripcion;
}

