package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
import com.corenetworks.hotelMascotas.servicio.IDetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles_facturas")
public class DetalleFacturaControlador {
    //Dejamos el DTO pal final ya que lleva ids de todas las tablas
    @Autowired
    private IDetalleFacturaServicio servicio;

    @GetMapping
    public ResponseEntity<List<DetalleFactura>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listasTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> insertar(@RequestBody DetalleFactura dF)throws Exception {
        DetalleFactura dF1 = servicio.insertar(dF);
        return new ResponseEntity<>(dF1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> consultarUno(@PathVariable("id") int id)throws Exception {
        DetalleFactura dF1 = servicio.listarUno(id);
        if (dF1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(dF1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DetalleFactura> modificar(@RequestBody DetalleFactura dF)throws  Exception {
        DetalleFactura dF1 = servicio.listarUno(dF.getIdDetalleFactura());
        if (dF1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +dF.getIdDetalleFactura());
        }
        return new ResponseEntity<>(servicio.modificar(dF), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
       DetalleFactura dF1 = servicio.listarUno(id);
        if (dF1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
