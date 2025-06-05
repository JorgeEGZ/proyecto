package edu.universidad.inventario.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import edu.universidad.inventario.repository.UsuarioRepository;
import java.io.IOException;
import edu.universidad.inventario.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Component;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);
        if (!jwtUtil.isTokenValid(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtUtil.extractUsername(jwt);
        Usuario usuario = usuarioRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                usuario.getNombreUsuario(),
                null,
                List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name()))
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
    }
}
