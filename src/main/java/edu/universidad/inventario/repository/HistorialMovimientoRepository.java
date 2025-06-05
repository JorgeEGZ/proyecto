package edu.universidad.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.universidad.inventario.entity.HistorialMovimiento;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface HistorialMovimientoRepository extends JpaRepository<HistorialMovimiento, Long> {
    List<HistorialMovimiento> findByEntidad(String entidad);
    List<HistorialMovimiento> findByUsuario(String usuario);
    List<HistorialMovimiento> findByFechaBetween(LocalDateTime desde, LocalDateTime hasta);
}

