package com.corenetworks.hotelMascotas.servicio.impl;


import com.corenetworks.hotelMascotas.modelo.Reserva;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;

import com.corenetworks.hotelMascotas.repositorio.IReservaRepositorio;

import com.corenetworks.hotelMascotas.servicio.IReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServicioImpl extends CRUDImpl<Reserva,Integer>implements IReservaServicio {
    @Autowired
    private IReservaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Reserva, Integer> getRepo() {
        return repo;
    }
}
