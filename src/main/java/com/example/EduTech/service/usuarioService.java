package com.example.EduTech.service;
import com.example.EduTech.model.usuario;
import com.example.EduTech.repository.usuarioRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class usuarioService {
    @Autowired
    private usuarioRepository repo;


    public usuario registrarUsuario(usuario uwu){
        return repo.save(uwu);
    }

    public Optional<usuario> autenticar(String email, String password){
        return repo.findByEmail(email).filter(uwu->uwu.getPassword().equals(password));
    }
}
