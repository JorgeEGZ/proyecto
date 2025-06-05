package edu.universidad.inventario.repository;

import edu.universidad.inventario.entity.Requisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicionRepository extends JpaRepository<Requisicion, Long> {
}
