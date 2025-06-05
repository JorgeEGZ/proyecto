package edu.universidad.inventario.mapper;


import java.util.List;
import org.mapstruct.Mapper;
import edu.universidad.inventario.dto.AsignaturaDTO;
import edu.universidad.inventario.entity.Asignatura;


@Mapper(componentModel = "spring")
public interface AsignaturaMapper {

    AsignaturaDTO toDTO(Asignatura asignatura);

    Asignatura toEntity(AsignaturaDTO dto);

    List<AsignaturaDTO> toDTOList(List<Asignatura> list);
}

