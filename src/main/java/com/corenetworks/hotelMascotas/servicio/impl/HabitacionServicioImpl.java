package com.corenetworks.hotelMascotas.servicio.impl;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IHabitacionRepositorio;
import com.corenetworks.hotelMascotas.servicio.IHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitacionServicioImpl extends CRUDImpl<Habitacion,Integer>implements IHabitacionServicio {
    @Autowired
    private IHabitacionRepositorio repo;
    @Override
    protected IGenericoRepositorio<Habitacion, Integer> getRepo() {
        return repo;
    }
}
