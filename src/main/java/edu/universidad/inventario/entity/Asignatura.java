package edu.universidad.inventario.entity;

import edu.universidad.inventario.entity.Asignatura;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String docente;

    private String codigo;
}

