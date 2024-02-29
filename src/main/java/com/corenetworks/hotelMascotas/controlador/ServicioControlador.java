package com.corenetworks.hotelMascotas.controlador;

import com.corenetworks.hotelMascotas.dto.ServicioDTO;
import com.corenetworks.hotelMascotas.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.hotelMascotas.modelo.Servicio;
import com.corenetworks.hotelMascotas.servicio.IServicioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioControlador {
        @Autowired
        private IServicioServicio servicio;

        @PostMapping
        public ResponseEntity<ServicioDTO> crearServicio(@Valid @RequestBody ServicioDTO e) throws Exception {
            Servicio s1 = e.castServicio();
            s1 = servicio.insertar(s1);
            return new ResponseEntity<>(e.castServicioADto(s1), HttpStatus.CREATED);
        }

        @PutMapping
        public ResponseEntity<ServicioDTO> modificarServicio(@Valid @RequestBody ServicioDTO e) throws Exception {
            Servicio s1 = servicio.listarUno(e.getIdServicio());
            if (s1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("No re seconoce el ID " + e.getIdServicio());
            }
            s1 = servicio.modificar(e.castServicio());
            return new ResponseEntity<>(e.castServicioADto(s1), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ServicioDTO> consultarUno(@PathVariable(name = "id") Integer id) throws Exception {
            Servicio s1 = servicio.listarUno(id);
            if (s1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
            }
            return new ResponseEntity<>((new ServicioDTO()).castServicioADto(s1), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable("id") int id) throws Exception {
            Servicio s1 = servicio.listarUno(id);
            if (s1 == null) {
                throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
            }
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping
        public ResponseEntity<List<ServicioDTO>> consultarTodos() throws Exception {
            List<Servicio> ServiciosBBDD = servicio.listasTodos();
            List<ServicioDTO> ServiciosDto = new ArrayList<>();
            for (Servicio elemento :
                    ServiciosBBDD) {
                ServicioDTO eDto = new ServicioDTO();
                ServiciosDto.add(eDto.castServicioADto(elemento));
            }
            return new ResponseEntity<>(ServiciosDto, HttpStatus.OK);
        }

    }

