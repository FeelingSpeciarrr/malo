package com.example.EduTech.controller;

import com.example.EduTech.model.noti;
import com.example.EduTech.service.notiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/noti")
public class notiController {
    
    @Autowired
    private notiService notiService;
    
    @GetMapping
    public List<noti> listarNoti(){
        return notiService.getNotis();
    }

    @PostMapping
    public noti agregarNoti(@RequestBody noti noti){
        return notiService.saveNoti(noti);
    }

    @GetMapping("{id}")
    public noti buscarNoti(@PathVariable int id){
        return notiService.geNoti(id);
    }

    @PutMapping("{id}")
    public noti actualizarNoti(@PathVariable int id, @RequestBody noti noti){
        return notiService.updateNoti(noti);
    }

    @DeleteMapping("{id}")
    public String eliminarNoti(@PathVariable int id){
        return notiService.deleteNoti(id);
    }

    @GetMapping("/total")
    public int totalNotiV2(){
        return notiService.totalNotiV2();
    }
}
