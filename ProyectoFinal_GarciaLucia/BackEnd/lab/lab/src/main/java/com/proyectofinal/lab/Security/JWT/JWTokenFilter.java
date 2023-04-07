/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.lab.Security.JWT;

import com.proyectofinal.lab.Security.Service.UsuarioDetailsImp;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Usuario
 */
public class JWTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JWTProvider.class);
    @Autowired
    JWTProvider jwtProvider;
    @Autowired
    UsuarioDetailsImp usuarioDetailsServiceImp;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request);
            if (token != null && jwtProvider.validateToken(token)) {
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails usuarioDetails = usuarioDetailsServiceImp.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuarioDetails, null, usuarioDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error("Fallo el metodo doFilterInternal");
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.replace("Beadrer", "");
        }
        return null;
    }
}
