package edu.universidad.inventario.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import edu.universidad.inventario.dto.UsuarioDTO;
import edu.universidad.inventario.mapper.UsuarioMapper;
import edu.universidad.inventario.repository.UsuarioRepository;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder; 

    @Override
    public List<UsuarioDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public UsuarioDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        var usuario = mapper.toEntity(dto);

        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));

        return mapper.toDTO(repository.save(usuario));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

