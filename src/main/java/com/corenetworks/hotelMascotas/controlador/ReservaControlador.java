package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Reserva;

import com.corenetworks.hotelMascotas.servicio.IReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservas")
public class ReservaControlador {
    @Autowired
    private IReservaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Reserva>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listasTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reserva> insertar(@RequestBody Reserva r)throws Exception {
        Reserva r1 = servicio.insertar(r);
        return new ResponseEntity<>(r1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> consultarUno(@PathVariable("id") int id)throws Exception {
        Reserva r1 = servicio.listarUno(id);
        if (r1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(r1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Reserva> modificar(@RequestBody Reserva r)throws  Exception {
        Reserva r1 = servicio.listarUno(r.getIdReserva());
        if (r1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +r.getIdReserva());
        }
        return new ResponseEntity<>(servicio.modificar(r), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Reserva r1 = servicio.listarUno(id);
        if (r1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
