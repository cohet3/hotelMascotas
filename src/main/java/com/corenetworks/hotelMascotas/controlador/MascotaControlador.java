package com.corenetworks.hotelMascotas.controlador;


import com.corenetworks.hotelMascotas.dto.MascotaDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.servicio.IMascotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaControlador {
    @Autowired
    private IMascotaServicio servicio;
    @PutMapping
    public ResponseEntity<MascotaDTO> modificarMascota(@RequestBody MascotaDTO m)throws  Exception {
        System.out.println(m.toString());
        Mascota m1 = servicio.listarUno(m.getIdMascota());



        if (m1==null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Mascota no encontrada" +m.getIdMascota());
        }
        m1=servicio.modificar(m.castMascota());
        return new ResponseEntity<>(m.castMascotaDTO(m1), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> consultarTodos() throws Exception {
        List<Mascota> mascotasBBDD = servicio.listasTodos();
        List<MascotaDTO> empleadosDto = new ArrayList<>();
        for (Mascota elemento:
                mascotasBBDD) {
            MascotaDTO eDto = new MascotaDTO();
            empleadosDto.add(eDto.castMascotaDTO(elemento));
        }
        return new ResponseEntity<>(empleadosDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> insertarMascota(@RequestBody MascotaDTO m)throws Exception {
        Integer i =servicio.insertarUnaMascota(m);
        System.out.println(i);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> consultarUno(@PathVariable("id") Integer id)throws Exception {
        Mascota m1 = servicio.listarUno(id);
        if (m1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>((new MascotaDTO()).castMascotaDTO(m1) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Mascota m1 = servicio.listarUno(id);
        if (m1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
