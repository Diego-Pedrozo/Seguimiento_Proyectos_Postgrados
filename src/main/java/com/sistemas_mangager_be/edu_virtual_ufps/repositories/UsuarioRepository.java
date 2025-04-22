package com.sistemas_mangager_be.edu_virtual_ufps.repositories;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
     // Metodo para buscar un usuario mediante su correo
     Optional<Usuario> findByEmail(String email);
    
     // Metodo para buscar un usuario mediante su googleId
     Optional<Usuario> findByGoogleId(String googleId);

     // Metodo para verificar si el usuario existe en la base de datos
     Boolean  existsByEmail(String email);
}
