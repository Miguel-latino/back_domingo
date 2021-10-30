/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tutoria.domingo.modelo.Habitacion;
import tutoria.domingo.servicios.ServiciosHabitacion;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebHabitacion {
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola mamaaaaa";
    }

    
    @Autowired
    private ServiciosHabitacion servicio;
    @GetMapping("all")
    public List <Habitacion> getHabitacion(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Habitacion> getHabitacion(@PathVariable("id") int idHabitacion) {
        return servicio.getHabitacion(idHabitacion);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Habitacion save(@RequestBody Habitacion habitacion) {
        return servicio.save(habitacion);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Habitacion update(@RequestBody Habitacion habitacion) {
        return servicio.update(habitacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int habitacionId) {
        return servicio.deleteHabitacion(habitacionId);
    }
}
