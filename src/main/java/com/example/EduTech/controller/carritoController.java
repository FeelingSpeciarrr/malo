package com.example.EduTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EduTech.model.curso;
import com.example.EduTech.service.cursoService;

import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/carrito")

public class carritoController {
    private final List<curso> carrito=new ArrayList<>();
    @Autowired
    private cursoService cursoServ;
    //Metodo para agregar un libro al carro de compras
        @PostMapping("/agregar/{id}")
        public String agregar(@PathVariable int id) {
           curso curso =cursoServ.getCursoId(id);
           if(curso!=null){
            carrito.add(curso);
            return  "Curso agregado al carrito:"+curso.getNombre();
           } 
           
           return  "Curso no fue encontrado";

        }
        
    @GetMapping
    public List<curso>verCarrito() {
        return carrito;
    }
    

    //Metodo para eliminar items del carrito
    @DeleteMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id){
        boolean eliminar=carrito.removeIf(curso->curso.getId()==id);
        return eliminar ? "Curso eliminado del carrito":"Libro no fue encontrado";
    }
    //Metodo para vaciar carro
    @DeleteMapping("/vaciar")
    public String vaciarCarrito(){
        carrito.clear();
        return "Carrito vacio";
    }
    //Metodo para contar los cursos en el carrito
    @GetMapping("/total")
    public int totalCursos() {
        return carrito.size();
    }

}
