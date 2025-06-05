package com.example.EduTech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class curso {
    
    private int id;
    private String nombre;
    private String categoria;
    private int precio;
    private String instructor;
    private String fechaActualizacion;
}
