package com.example.EduTech.controller;

import com.example.EduTech.model.curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/cursos")
public class cursoController {
    
    @Autowired
    private com.example.EduTech.service.cursoService cursoService;

    @GetMapping
    public List<curso> listarCursos() {
        return cursoService.getCurso();
    }

    @GetMapping("{nombre}")
    public curso buscarCurso(@PathVariable String nombre) {
        return cursoService.getCursoNombre(nombre);
    }
    
    @GetMapping("/total")
    public int totalCursosV2() {
        return cursoService.totalCursosV2();
    }
    
}
