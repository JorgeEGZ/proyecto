package edu.universidad.inventario.mapper;

import edu.universidad.inventario.dto.UsuarioDTO;
import edu.universidad.inventario.entity.Usuario;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol())
                .build();
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        
        return Usuario.builder()
                .id(dto.getId())
                .nombreUsuario(dto.getNombreUsuario())
                .contrasena(dto.getContrasena())
                .rol(dto.getRol())
                .build();
    }

    public List<UsuarioDTO> toDTOList(List<Usuario> list) {
        if (list == null) return null;
        return list.stream().map(this::toDTO).toList();
    }
}