package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.servicio.IHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionControlador {
    @Autowired
    private IHabitacionServicio servicio;

    @GetMapping
    public ResponseEntity<List<Habitacion>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listasTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Habitacion> insertar(@RequestBody Habitacion h)throws Exception {
        Habitacion h1 = servicio.insertar(h);
        return new ResponseEntity<>(h1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> consultarUno(@PathVariable("id") int id)throws Exception {
        Habitacion h1 = servicio.listarUno(id);
        if (h1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(h1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Habitacion> modificar(@RequestBody Habitacion h)throws  Exception {
        Habitacion h1 = servicio.listarUno(h.getIdHabitacion());
        if (h1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +h.getIdHabitacion());
        }
        return new ResponseEntity<>(servicio.modificar(h), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Habitacion h1 = servicio.listarUno(id);
        if (h1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
