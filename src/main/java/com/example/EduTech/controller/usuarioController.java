package com.example.EduTech.controller;
import com.example.EduTech.model.usuario;
import com.example.EduTech.service.usuarioService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/usuarios")// Url base para las peticiones http
@CrossOrigin //Permitir peticiones desde cualquier origen
public class usuarioController {
    @Autowired
    private usuarioService serv;

    @PostMapping("/registrar")//metodo para registrar un usuario en la tabla usuario
    public usuario registrar(@RequestBody usuario u) {
        
        
        return serv.registrarUsuario(u);
    }
    //Metodo para autenticar usuario
    @PostMapping("/login")
    public Map<String,String> login(@RequestBody usuario u){

        Optional<usuario> user= serv.autenticar(u.getEmail(), u.getPassword());
        Map<String,String> response= new HashMap<>();
        if(user.isPresent()){
            response.put("result", "OK");
            response.put("nombre", user.get().getNombre());
        }else{

            response.put("result","error" );
        }
        return response;
    }
    

    


}
