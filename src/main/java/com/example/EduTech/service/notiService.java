package com.example.EduTech.service;
import com.example.EduTech.model.noti;
import com.example.EduTech.repository.notiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class notiService {
    @Autowired
    private notiRepository notiRepository;

    public List<noti> getNotis() {
        return notiRepository.obtenerNoti();
    }

    public noti geNoti(int id) {
        return notiRepository.buscarPorId(id);
    }

    public noti saveNoti(noti noti) {
        return notiRepository.guardarNoti(noti);
    }

    public noti updateNoti(noti noti) {
        return notiRepository.actualizarNoti(noti);
    }

    public int totalNoti(){
        return notiRepository.obtenerNoti().size();
    }

    public String deleteNoti(int id){
        notiRepository.eliminarNoti(id);
        return "Notificaion eliminada";  
    }

    public int totalNotiV2(){
        return notiRepository.totalNoti();
    }
}
