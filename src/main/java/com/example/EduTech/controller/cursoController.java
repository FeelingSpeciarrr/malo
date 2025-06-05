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
        return cursoService.getCurso(nombre);
    }
    
    @GetMapping("/total")
    public int totalCursosV2() {
        return cursoService.totalCursosV2();
    }

     @GetMapping("/agregar/{id}")
     public curso agregar (@PathVariable curso c) {
         return cursoService.agregarCurso(c);
     }

     @PutMapping("/update/{id}")
     public curso update(@PathVariable curso c) {
         return cursoService.updateCurso(c);
     }

    @DeleteMapping("/delete/{id}")
     public String delete(@PathVariable int id) {
         return cursoService.deleteCurso(id);
     }
     
     
    
}
