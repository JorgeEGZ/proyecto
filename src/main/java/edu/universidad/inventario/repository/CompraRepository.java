package edu.universidad.inventario.repository;

import edu.universidad.inventario.entity.Compra;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
        List<Compra> findByFechaCompraBetween(LocalDate desde, LocalDate hasta);

}
