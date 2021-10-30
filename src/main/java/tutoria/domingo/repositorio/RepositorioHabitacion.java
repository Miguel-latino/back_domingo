/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.domingo.interfaces.InterfaceHabitacion;
import tutoria.domingo.modelo.Habitacion;

/**
 *
 * @author Cliente
 */
@Repository
public class RepositorioHabitacion {
    @Autowired
    private InterfaceHabitacion crud;
    

    public List<Habitacion> getAll(){
        return (List<Habitacion>) crud.findAll();       
    }
    
    public Optional <Habitacion> getHabitacion(int id){
        return crud.findById(id);
    }
    
    public Habitacion save(Habitacion habitacion){
        return crud.save(habitacion);
    }
      public void delete(Habitacion habitacion){
        crud.delete(habitacion);
    }
}











