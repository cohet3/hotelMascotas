package com.corenetworks.hotelMascotas.repositorio;

import com.corenetworks.hotelMascotas.modelo.Servicio;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServicioRepo extends IGenericoRepositorio<Servicio, Integer> {
    @Query(value = "Select * from servicios;",nativeQuery = true)
    public List<Object[]> obtenerServicios();
}
