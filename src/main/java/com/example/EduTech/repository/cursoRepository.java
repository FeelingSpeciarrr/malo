package com.example.EduTech.repository;

import com.example.EduTech.model.curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class cursoRepository {
    
    private List<curso> listaCursos = new ArrayList<>();

    public cursoRepository(){
        listaCursos.add(new curso(1, "Curso 4k full HD no Fake sobre Python", "Programacion", 1990, "Fokin Jhoao","20-05-2025"));
        listaCursos.add(new curso(2, "Como hablar con feminas", "Social", 100, "Eduardo P.","02-07-2019"));
        listaCursos.add(new curso(3, "Curso de COMO DORMIR (DOU)", "Salud", 1000, "Seba GOD","11-11-2011"));
        listaCursos.add(new curso(4, "Curso de COMO DESPERTAR (T.T)", "Salud", 10000, "Seba GOD","11-11-2021"));
    }

    public List<curso> obtenerCursos(){
        return listaCursos;
    }

    public curso buscarCurso(String nom){
        for (curso cur : listaCursos) {
            if(cur.getNombre().equalsIgnoreCase(nom)){
                return cur;
            }
        }
        return null;
    }

    public int totalCursos(){
        return listaCursos.size();
    }

}
