package edu.universidad.inventario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "requisicion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requisicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private Integer numeroEstudiantes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "requisicion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleRequisicion> detalles;
}

