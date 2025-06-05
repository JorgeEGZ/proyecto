package edu.universidad.inventario.repository;

import edu.universidad.inventario.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByDocente(String docente);

}
