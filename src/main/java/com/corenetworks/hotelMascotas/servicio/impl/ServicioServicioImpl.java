package com.corenetworks.hotelMascotas.servicio.impl;

import com.corenetworks.hotelMascotas.modelo.Servicio;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IServicioRepo;
import com.corenetworks.hotelMascotas.servicio.IHabitacionServicio;
import com.corenetworks.hotelMascotas.servicio.IServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServicioImpl extends CRUDImpl<Servicio,Integer>implements IServicioServicio {
    @Autowired
    private IServicioRepo repo;
    @Override
    protected IGenericoRepositorio<Servicio, Integer> getRepo() {
        return repo;
    }
}
