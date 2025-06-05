package edu.universidad.inventario.config;

import edu.universidad.inventario.entity.Insumo;
import edu.universidad.inventario.entity.Proveedor;
import edu.universidad.inventario.entity.Usuario;
import edu.universidad.inventario.entity.Usuario.Rol;
import edu.universidad.inventario.repository.InsumoRepository;
import edu.universidad.inventario.repository.ProveedorRepository;
import edu.universidad.inventario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final UsuarioRepository usuarioRepo;
    private final ProveedorRepository proveedorRepo;
    private final InsumoRepository insumoRepo;
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            if (usuarioRepo.count() == 0) {
                usuarioRepo.save(Usuario.builder()
                        .nombreUsuario("admin")
                        .contrasena(passwordEncoder.encode("admin123"))
                        .rol(Rol.ADMIN)
                        .build());

                usuarioRepo.save(Usuario.builder()
                        .nombreUsuario("almacen")
                        .contrasena(passwordEncoder.encode("almacen123"))
                        .rol(Rol.ALMACEN)
                        .build());

                usuarioRepo.save(Usuario.builder()
                        .nombreUsuario("docente")
                        .contrasena(passwordEncoder.encode("docente123"))
                        .rol(Rol.DOCENTE)
                        .build());
            }

            if (proveedorRepo.count() == 0) {
                proveedorRepo.save(Proveedor.builder()
                        .nombre("Proveedor A")
                        .contacto("Juan Pérez")
                        .telefono("123456789")
                        .direccion("Calle 123")
                        .tipoProductos("Insumos secos")
                        .build());

                proveedorRepo.save(Proveedor.builder()
                        .nombre("Proveedor B")
                        .contacto("Ana Gómez")
                        .telefono("987654321")
                        .direccion("Av. Principal")
                        .tipoProductos("Refrigerados")
                        .build());
            }

            if (insumoRepo.count() == 0) {
                insumoRepo.save(Insumo.builder()
                        .nombre("Harina")
                        .unidadMedida("kg")
                        .stock(BigDecimal.valueOf(100))
                        .build());

                insumoRepo.save(Insumo.builder()
                        .nombre("Leche")
                        .unidadMedida("litros")
                        .stock(BigDecimal.valueOf(50))
                        .build());

                insumoRepo.save(Insumo.builder()
                        .nombre("Huevos")
                        .unidadMedida("docena")
                        .stock(BigDecimal.valueOf(30))
                        .build());
            }
        };
    }
}