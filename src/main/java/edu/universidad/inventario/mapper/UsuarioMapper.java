package edu.universidad.inventario.mapper;

import edu.universidad.inventario.dto.UsuarioDTO;
import edu.universidad.inventario.entity.Usuario;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(Usuario usuario);

    Usuario toEntity(UsuarioDTO dto);

    List<UsuarioDTO> toDTOList(List<Usuario> list);
}

