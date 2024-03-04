package com.corenetworks.hotelMascotas.servicio;

import com.corenetworks.hotelMascotas.modelo.Servicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicioServicio extends ICRUD<Servicio,Integer>{

    List<Object[]> obtenerServicios();
}
