package com.example.EduTech.repository;

import com.example.EduTech.model.curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class cursoRepository {
    
    private List<curso> listaCursos = new ArrayList<>();

    public cursoRepository(){
        listaCursos.add(new curso(1, "Python para principiantes", "Programacion", 7990, "Juan Perez","20-05-2025"));
        listaCursos.add(new curso(2, "Base de Datos Avanzada", "Programacion", 16990, "Fabian Ulloa","02-07-2019"));
        listaCursos.add(new curso(3, "Fundamentos de Ciberseguridad", "Seguridad", 12500, "Andres Carrasco","11-11-2011"));
        listaCursos.add(new curso(4, "Frances desde 0", "Idioma", 9000, "Javiera Diaz","11-11-2021"));
    }



    public List<curso> obtenerCursos(){
        return listaCursos;
    }

    public curso buscarCursoId(int id){
        for (curso cur : listaCursos) {
            if(cur.getId()==id){
                return cur;
            }
        }
        return null;
    }

    public curso buscarCurso(String nombre){
        for (curso cur : listaCursos) {
            if(cur.getNombre().equals(nombre)){
                return cur;
            }
        }
        return null;
    }

    public curso guardar(curso cu){
        long nuevoid=1;
        for(curso c :listaCursos){
            if(c.getId()>=nuevoid){
                nuevoid= c.getId()+1;
            }
        }
    
        curso curso=new curso();
        curso.setId((int) nuevoid);
        curso.setNombre(cu.getNombre());
        curso.setCategoria(cu.getCategoria());
        curso.setPrecio(cu.getPrecio());
        curso.setInstructor(cu.getInstructor());
        curso.setFechaActualizacion(cu.getFechaActualizacion());
        listaCursos.add(curso);
        return curso;
    }

    public int totalCursos(){
        return listaCursos.size();
    }
    public void eliminarCurso(int id){
        listaCursos.removeIf(x ->x.getId()==id);
    }

     public curso actualizar(curso c) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getId() == c.getId()) {
                id = c.getId();
                idPosicion = i;
            }
        }

        curso cu = new curso();
        cu.setId(id);
        cu.setNombre(c.getNombre());
        cu.setCategoria(c.getCategoria());
        cu.setPrecio(c.getPrecio());
        cu.setInstructor(c.getInstructor());
        cu.setFechaActualizacion(c.getFechaActualizacion());

        listaCursos.set(idPosicion, cu);
        return cu;
    }
}
