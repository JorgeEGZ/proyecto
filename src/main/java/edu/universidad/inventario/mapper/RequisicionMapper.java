package edu.universidad.inventario.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import edu.universidad.inventario.dto.DetalleRequisicionDTO;
import edu.universidad.inventario.dto.RequisicionDTO;
import edu.universidad.inventario.entity.DetalleRequisicion;
import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.entity.Requisicion;
import edu.universidad.inventario.repository.AsignaturaRepository;
import edu.universidad.inventario.repository.InsumoRepository;
import edu.universidad.inventario.repository.UsuarioRepository;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class RequisicionMapper {  // ← Quitar "abstract"
    
    @Autowired
    protected AsignaturaRepository asignaturaRepository;


    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected InsumoRepository insumoRepository;

    public Requisicion toEntity(RequisicionDTO dto) {
        Requisicion requisicion = new Requisicion();
        requisicion.setId(dto.getId());
        requisicion.setFecha(dto.getFecha());
        requisicion.setNumeroEstudiantes(dto.getNumeroEstudiantes());

        requisicion.setAsignatura(asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada")));

        requisicion.setUsuario(usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        List<DetalleRequisicion> detalles = dto.getDetalles().stream().map(detalleDTO -> {
            Insumo insumo = insumoRepository.findById(detalleDTO.getInsumoId())
                    .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));

            return DetalleRequisicion.builder()
                    .id(detalleDTO.getId())
                    .insumo(insumo)
                    .cantidadUtilizada(detalleDTO.getCantidadUtilizada())
                    .unidad(detalleDTO.getUnidad())
                    .costoUnitario(detalleDTO.getCostoUnitario())
                    .valorTotal(detalleDTO.getValorTotal())
                    .requisicion(requisicion)
                    .build();
        }).toList();

        requisicion.setDetalles(detalles);
        return requisicion;
    }

    public RequisicionDTO toDTO(Requisicion requisicion) {
        return RequisicionDTO.builder()
                .id(requisicion.getId())
                .fecha(requisicion.getFecha())
                .numeroEstudiantes(requisicion.getNumeroEstudiantes())
                .asignaturaId(requisicion.getAsignatura().getId())
                .usuarioId(requisicion.getUsuario().getId())
                .detalles(requisicion.getDetalles().stream().map(detalle ->
                        DetalleRequisicionDTO.builder()
                                .id(detalle.getId())
                                .insumoId(detalle.getInsumo().getId())
                                .cantidadUtilizada(detalle.getCantidadUtilizada())
                                .unidad(detalle.getUnidad())
                                .costoUnitario(detalle.getCostoUnitario())
                                .valorTotal(detalle.getValorTotal())
                                .build()
                ).toList())
                .build();
    }

    public List<RequisicionDTO> toDTOList(List<Requisicion> list) {
        return list.stream().map(this::toDTO).toList();
    }
}

