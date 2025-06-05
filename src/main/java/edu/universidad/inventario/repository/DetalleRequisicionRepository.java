package edu.universidad.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import edu.universidad.inventario.dto.ConsumoInsumoPorAsignaturaDTO;
import edu.universidad.inventario.entity.DetalleRequisicion;


@Repository
public interface DetalleRequisicionRepository extends JpaRepository<DetalleRequisicion, Long> {
    @Query("""
    SELECT 
        a.nombre AS asignatura,
        i.nombre AS insumo,
        dr.unidad AS unidad,
        SUM(dr.cantidadUtilizada) AS cantidadTotal
    FROM DetalleRequisicion dr
    JOIN dr.requisicion r
    JOIN r.asignatura a
    JOIN dr.insumo i
    GROUP BY a.nombre, i.nombre, dr.unidad
    ORDER BY a.nombre, i.nombre
""")
List<ConsumoInsumoPorAsignaturaDTO> getConsumoInsumosPorAsignatura();

}
