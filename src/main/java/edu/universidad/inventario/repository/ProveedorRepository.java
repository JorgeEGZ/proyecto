package edu.universidad.inventario.repository;

import edu.universidad.inventario.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}

