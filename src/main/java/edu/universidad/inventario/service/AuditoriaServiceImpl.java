package edu.universidad.inventario.service;

import edu.universidad.inventario.entity.HistorialMovimiento;
import edu.universidad.inventario.repository.HistorialMovimientoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditoriaServiceImpl implements AuditoriaService {

    private final HistorialMovimientoRepository repo;

    @Override
    public void registrar(String entidad, String accion, Long entidadId, String descripcion) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String usuario = (auth != null) ? auth.getName() : "ANONIMO";

        HistorialMovimiento historial = HistorialMovimiento.builder()
                .entidad(entidad)
                .accion(accion)
                .entidadId(entidadId)
                .usuario(usuario)
                .descripcion(descripcion)
                .fecha(LocalDateTime.now())
                .build();

        repo.save(historial);
    }

}

