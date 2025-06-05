package edu.universidad.inventario.service;

public interface AuditoriaService {
    void registrar(String entidad, String accion, Long entidadId, String descripcion);
    
}

