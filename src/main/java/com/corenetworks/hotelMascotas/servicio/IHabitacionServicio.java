package com.corenetworks.hotelMascotas.servicio;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.modelo.Servicio;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;

public interface IHabitacionServicio extends ICRUD<Habitacion,Integer> {
    interface IServicioRepo extends IGenericoRepositorio<Servicio,Integer> {
    }
}
