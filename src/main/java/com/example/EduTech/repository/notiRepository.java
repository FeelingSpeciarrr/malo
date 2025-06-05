package com.example.EduTech.repository;


import com.example.EduTech.model.noti;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class notiRepository {
    
    //Arreglo que guarda las notificaciones
    private List<noti> listaNotificaciones = new ArrayList<>();
    public notiRepository(){
        listaNotificaciones.add(new noti(1, "Sin notificaciones"));
    }

    //Metodo que retorna las notificaciones
    public List<noti> obtenerNoti(){
        return listaNotificaciones;
    }

    //Metodo que permite guardadar las notificaciones
    public noti guardarNoti(noti not){
        int nuevoId = 1;
        for(noti i : listaNotificaciones){
            if(i.getId() >= nuevoId){
                nuevoId = i.getId() + 1;
            }
        }
        noti Noti = new noti();
        Noti.setId(nuevoId);
        Noti.setMensaje(not.getMensaje());
        listaNotificaciones.add(not);
        return not;
    }

    //Metodo que permite buscar una notificacion por su id
    public noti buscarPorId(int id){
        for(noti Noti : listaNotificaciones){
            if(Noti.getId() == id){
                return Noti;
            }
        }
        return null;
    }

    //Metodo para eliminar notificaciones
    public void eliminarNoti(int id){
        noti Noti = buscarPorId(id);
        if (Noti != null) {
            listaNotificaciones.remove(Noti);
        }
    }

    //Metodo que retorna la cantidad de notificaciones registradas
    public int totalNoti(){
        return listaNotificaciones.size();
    }


    // metodo para actualizar las notificaciones 
    public noti actualizarNoti(noti not){
        int id = 0;
        int idPosi = 0;

        for(int i = 0; i < listaNotificaciones.size(); i++){
            if(listaNotificaciones.get(i).getId() ==not.getId()){
                id = not.getId();
                idPosi = 1;
            }
        }

        noti Noti1 = new noti();
        Noti1.setId(id);
        Noti1.setMensaje(not.getMensaje());

        listaNotificaciones.set(idPosi, Noti1);
        return Noti1;

        
    }
}
