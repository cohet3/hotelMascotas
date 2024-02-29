package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.FacturaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Factura;
import com.corenetworks.hotelMascotas.servicio.IFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaControlador {
    @Autowired
    private IFacturaServicio servicio;
    @PostMapping
    public ResponseEntity<FacturaDTO> insertarFactura(@RequestBody FacturaDTO f)throws Exception {
        //no funciona
        Factura f1 = f.castFactura();
        f1 =servicio.insertar(f1);
        return new ResponseEntity<>(new FacturaDTO().castFacturaDto(f1), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> consultarTodos() throws Exception {
        List<Factura> facturasBBDD = servicio.listasTodos();
        List<FacturaDTO> facturasDTo = new ArrayList<>();
        for (Factura elemento:
        facturasBBDD){
            FacturaDTO eDto= new FacturaDTO();
            facturasDTo.add(eDto.castFacturaDto(elemento));
        }
        return new ResponseEntity<>(facturasDTo, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<FacturaDTO> modificarFactura(@RequestBody FacturaDTO f)throws  Exception {
        //no funciona
        Factura f1 = servicio.listarUno(f.getIdFactura());
        if (f1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("FActura no encontrada" +f.getIdFactura());
        }
        f1= servicio.modificar(f.castFactura());
        return new ResponseEntity<>(f.castFacturaDto(f1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> consultarUno(@PathVariable("id") Integer id)throws Exception {
        Factura f1 = servicio.listarUno(id);
        if (f1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("factura no encontrado con ID " + id);
        }
        return new ResponseEntity<>((new FacturaDTO()).castFacturaDto(f1), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")Integer id)throws Exception {
       Factura f1 = servicio.listarUno(id);
        if (f1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Factura no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
