package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.ReservaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Reserva;

import com.corenetworks.hotelMascotas.servicio.IReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaControlador {
    @Autowired
    private IReservaServicio servicio;
    @PostMapping
    public ResponseEntity<ReservaDTO> insertar(@RequestBody ReservaDTO r)throws Exception {
        Reserva r1 = r.castReserva();
        r1 = servicio.insertar(r1);
        return new ResponseEntity<>(r.castReservaDTO(r1), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ReservaDTO> modificar(@RequestBody ReservaDTO r)throws  Exception {
        Reserva r1 = servicio.listarUno(r.getIdReserva());
        if (r1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +r.getIdReserva());
        }
        r1= servicio.modificar(r.castReserva());
        return new ResponseEntity<>(r.castReservaDTO(r1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> consultarUno(@PathVariable("id") Integer id)throws Exception {
        Reserva r1 = servicio.listarUno(id);
        if (r1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>((new ReservaDTO()).castReservaDTO(r1), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")Integer id)throws Exception {
        Reserva r1 = servicio.listarUno(id);
        if (r1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> consultarTodos() throws Exception {
        List<Reserva> reservasBBDD = servicio.listasTodos();
        List<ReservaDTO> reservasDto= new ArrayList<>();
        for(Reserva elemento:
        reservasBBDD){
           ReservaDTO eDto = new ReservaDTO();
           reservasDto.add(eDto.castReservaDTO(elemento));
        }
        return new ResponseEntity<>(reservasDto, HttpStatus.OK);
    }


}
