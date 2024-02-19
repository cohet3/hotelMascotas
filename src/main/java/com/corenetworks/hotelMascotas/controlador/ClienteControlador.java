package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    private IClienteServicio servicio;

    @GetMapping
    public ResponseEntity<List<Cliente>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listasTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> insertar( @RequestBody Cliente c)throws Exception {
        Cliente c1 = servicio.insertar(c);
        return new ResponseEntity<>(c1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> consultarUno(@PathVariable("id") int id)throws Exception {
        Cliente c1 = servicio.listarUno(id);
        if (c1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>(c1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Cliente> modificar(@RequestBody Cliente c)throws  Exception {
        Cliente c1 = servicio.listarUno(c.getIdCliente());
        if (c1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado" +c.getIdCliente());
        }
        return new ResponseEntity<>(servicio.modificar(c), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Cliente c1 = servicio.listarUno(id);
        if (c1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
