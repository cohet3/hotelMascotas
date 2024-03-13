package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.DetalleFacturaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
import com.corenetworks.hotelMascotas.servicio.IDetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detalles_facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleFacturaControlador {
    //Dejamos el DTO pal final ya que lleva ids de todas las tablas
    @Autowired
    private IDetalleFacturaServicio servicio;

    @GetMapping
    public ResponseEntity<List<DetalleFacturaDTO>> consultarTodos() throws Exception {
        List<DetalleFactura>detalleFacturasBBDD=servicio.listasTodos();
        List<DetalleFacturaDTO>detalleFacturaDTO=new ArrayList<>();
        for (DetalleFactura elemento:detalleFacturasBBDD)  {

            detalleFacturaDTO.add(new DetalleFacturaDTO().castDetalleFacturaDto(elemento));
        }

        return new ResponseEntity<>(detalleFacturaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleFacturaDTO> insertarDettalesFactura(@RequestBody DetalleFacturaDTO dF)throws Exception {
        System.out.println(dF.toString());
        DetalleFactura dF1 = dF.castDetalleFactura();
        dF1=servicio.insertar(dF1);
        return new ResponseEntity<>(dF.castDetalleFacturaDto(dF1), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFacturaDTO> consultarUno(@PathVariable(name="id") Integer id)throws Exception {
        DetalleFactura dF1 = servicio.listarUno(id);
        if (dF1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(new DetalleFacturaDTO().castDetalleFacturaDto(dF1), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DetalleFacturaDTO> modificarDetallesFactura(@RequestBody DetalleFacturaDTO dF)throws  Exception {
        DetalleFactura dF1 = servicio.listarUno(dF.getIdDetalleFactura());
        if (dF1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Detalle de Factura no encontrado" +dF.getIdDetalleFactura());
        }
        dF1=servicio.modificar(dF.castDetalleFactura());
        return new ResponseEntity<>(dF.castDetalleFacturaDto(dF1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name="id")Integer id)throws Exception {
       DetalleFactura dF1 = servicio.listarUno(id);
        if (dF1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
