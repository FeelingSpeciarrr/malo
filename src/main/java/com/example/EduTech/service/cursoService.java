package com.example.EduTech.service;

import com.example.EduTech.model.curso;
import com.example.EduTech.repository.cursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cursoService {
    @Autowired
    private cursoRepository cursoRepository;

    public List<curso> getCurso(){
        return cursoRepository.obtenerCursos();
    }
    
    public curso agregarCurso( curso c){
        return cursoRepository.guardar(c); 
    }

    public curso updateCurso(curso c){
        return cursoRepository.actualizar(c);
    }

    public curso getCursoId(int id){
        return cursoRepository.buscarCursoId(id);
    }

    public curso getCurso(String nombre){
        return cursoRepository.buscarCurso(nombre);
    }

    public int totalCursos(){
        return cursoRepository.obtenerCursos().size();
    }

    public int totalCursosV2(){
        return cursoRepository.totalCursos();
    }
    public String deleteCurso(int id){

        cursoRepository.eliminarCurso(id);
        return "Curso eliminado";
    }


}
