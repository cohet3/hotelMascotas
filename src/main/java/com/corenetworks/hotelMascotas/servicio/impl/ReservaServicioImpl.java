package com.corenetworks.hotelMascotas.servicio.impl;


import com.corenetworks.hotelMascotas.dto.ObtenerFechasDTO;
import com.corenetworks.hotelMascotas.dto.ReservaDTO;
import com.corenetworks.hotelMascotas.modelo.Reserva;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;

import com.corenetworks.hotelMascotas.repositorio.IReservaRepositorio;

import com.corenetworks.hotelMascotas.servicio.IReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaServicioImpl extends CRUDImpl<Reserva,Integer>implements IReservaServicio {
    @Autowired
    private IReservaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Reserva, Integer> getRepo() {
        return repo;
    }

    @Override
    public Integer insert1Reserva(ReservaDTO r) {
        return repo.insert1Reserva(r.getFechaEntrada(),r.getFechaSalida(),r.getPrecio(),r.getIdMascota(),r.getIdHabitacion());
    }

    @Override

    public List<Reserva> obtenerReservas(LocalDate f1, LocalDate f2) {
        return repo.obtenerReservas( f1, f2);

    }

}
