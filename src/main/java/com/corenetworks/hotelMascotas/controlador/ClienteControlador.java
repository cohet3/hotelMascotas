package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.ClienteDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    private IClienteServicio servicio;
    @PostMapping
    public ResponseEntity<ClienteDTO> insertarCliente(@RequestBody ClienteDTO c)throws Exception {
        Cliente c1 = c.castCliente();
        c1= servicio.insertar(c1);
        return new ResponseEntity<>(c.castClienteDto(c1), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ClienteDTO> modificarCliente(@RequestBody ClienteDTO c)throws  Exception {
        Cliente c1 = servicio.listarUno(c.getIdCliente());
        if (c1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("CLiente no encontrado" +c.getIdCliente());
        }
        c1 = servicio.modificar(c.castCliente());
        return new ResponseEntity<>(c.castClienteDto(c1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> consultarUno(@PathVariable("id") int id)throws Exception {
        Cliente c1 = servicio.listarUno(id);
        if (c1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Cliente no encontrado con ID " + id);
        }
        return new ResponseEntity<>((new ClienteDTO()).castClienteDto(c1), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name="id")Integer id)throws Exception {
        Cliente c1 = servicio.listarUno(id);
        if (c1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Cliente no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> consultarTodos() throws Exception {
        List<Cliente> clientesBBDD= servicio.listasTodos();
        List<ClienteDTO> clienteDto = new ArrayList<>();
        for (Cliente elemento:
        clientesBBDD){
            ClienteDTO eDto = new ClienteDTO();
            clienteDto.add(eDto.castClienteDto(elemento));
        }
        return new ResponseEntity<>(clienteDto, HttpStatus.OK);
    }


}
