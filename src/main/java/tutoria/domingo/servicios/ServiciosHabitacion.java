/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Habitacion;
import tutoria.domingo.repositorio.RepositorioHabitacion;

/**
 *
 * @author Cliente
 */
@Service
public class ServiciosHabitacion {
    @Autowired
    private RepositorioHabitacion metodosCrud;
    
    public List<Habitacion> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Habitacion> getHabitacion(int idHabitacion){
        return metodosCrud.getHabitacion(idHabitacion);
    }
    
    public Habitacion save(Habitacion habitacion){
        if(habitacion.getId()==null){
            return metodosCrud.save(habitacion);
        }else{
            Optional<Habitacion> evt=metodosCrud.getHabitacion(habitacion.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(habitacion);
            }else{
                return habitacion;
            }
        }
    }
    public Habitacion update(Habitacion habitacion){
        if(habitacion.getId()!=null){
            Optional<Habitacion> e=metodosCrud.getHabitacion(habitacion.getId());
            if(!e.isEmpty()){
                if(habitacion.getName()!=null){
                    e.get().setName(habitacion.getName());
                }
                if(habitacion.getHotel()!=null){
                    e.get().setHotel(habitacion.getHotel());
                }
                if(habitacion.getStars()!=null){
                    e.get().setStars(habitacion.getStars());
                }
                if(habitacion.getDescription()!=null){
                    e.get().setDescription(habitacion.getDescription());
                }
                if(habitacion.getCategory()!=null){
                    e.get().setCategory(habitacion.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return habitacion;
            }
        }else{
            return habitacion;
        }
    }


    public boolean deleteHabitacion(int habitacionId) {
        Boolean aBoolean = getHabitacion(habitacionId).map(habitacion -> {
            metodosCrud.delete(habitacion);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
