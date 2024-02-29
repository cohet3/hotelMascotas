package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.HabitacionDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.servicio.IHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/habitaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitacionControlador {
    @Autowired
    private IHabitacionServicio servicio;
    @PostMapping
    public ResponseEntity<HabitacionDTO> insertarHabita(@RequestBody HabitacionDTO h)throws Exception {
        Habitacion h1 = h.castHabitacion();
        h1 = servicio.insertar(h1);
        return new ResponseEntity<>(h.castHabitacionDto(h1), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<HabitacionDTO> modificarHabita(@RequestBody HabitacionDTO h)throws  Exception {
        Habitacion h1 = servicio.listarUno(h.getIdHabitacion());
        if (h1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +h.getIdHabitacion());
        }
        h1 = servicio.modificar(h.castHabitacion());
        return new ResponseEntity<>(h.castHabitacionDto(h1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDTO> consultarUno(@PathVariable("id") int id)throws Exception {
        Habitacion h1 = servicio.listarUno(id);
        if (h1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>((new HabitacionDTO()).castHabitacionDto(h1), HttpStatus.OK);
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

    @GetMapping
    public ResponseEntity<List<HabitacionDTO>> consultarTodos() throws Exception {
        List<Habitacion> habitacionesBBDD= servicio.listasTodos();
        List<HabitacionDTO> habitacionesDto= new ArrayList<>();
        for(Habitacion elemento:
        habitacionesBBDD){
            HabitacionDTO eDto= new HabitacionDTO();
            habitacionesDto.add(eDto.castHabitacionDto(elemento));
        }
        return new ResponseEntity<>(habitacionesDto, HttpStatus.OK);
    }






}
