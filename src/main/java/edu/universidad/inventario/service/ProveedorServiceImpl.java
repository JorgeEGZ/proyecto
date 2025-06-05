package edu.universidad.inventario.service;

import edu.universidad.inventario.dto.ProveedorDTO;
import java.util.List;
import edu.universidad.inventario.mapper.ProveedorMapper;
import edu.universidad.inventario.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import edu.universidad.inventario.entity.Proveedor;




@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repository;
    private final ProveedorMapper mapper;

    @Override
    public List<ProveedorDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public ProveedorDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public ProveedorDTO create(ProveedorDTO dto) {
        Proveedor proveedor = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(proveedor));
    }

    @Override
    public ProveedorDTO update(Long id, ProveedorDTO dto) {
        Proveedor proveedor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setNombre(dto.getNombre());
        proveedor.setContacto(dto.getContacto());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setTipoProductos(dto.getTipoProductos());

        return mapper.toDTO(repository.save(proveedor));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
