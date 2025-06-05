package com.example.EduTech.repository;

import com.example.EduTech.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface usuarioRepository extends JpaRepository<usuario,Long> {
    Optional<usuario> findByEmail(String email);
}
