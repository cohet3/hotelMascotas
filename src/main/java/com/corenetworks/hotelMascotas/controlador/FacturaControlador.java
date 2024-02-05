package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Factura;
import com.corenetworks.hotelMascotas.servicio.IFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaControlador {
    @Autowired
    private IFacturaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Factura>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listasTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Factura> insertar(@RequestBody Factura f)throws Exception {
        Factura f1 = servicio.insertar(f);
        return new ResponseEntity<>(f1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> consultarUno(@PathVariable("id") int id)throws Exception {
        Factura f1 = servicio.listarUno(id);
        if (f1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(f1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Factura> modificar(@RequestBody Factura f)throws  Exception {
        Factura f1 = servicio.listarUno(f.getIdFactura());
        if (f1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +f.getIdFactura());
        }
        return new ResponseEntity<>(servicio.modificar(f), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
       Factura f1 = servicio.listarUno(id);
        if (f1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
