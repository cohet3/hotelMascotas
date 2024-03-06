package com.corenetworks.hotelMascotas.servicio;

import com.corenetworks.hotelMascotas.modelo.Reserva;

import java.util.List;

public interface IReservaServicio extends ICRUD<Reserva,Integer> {
    List<Object[]> obtenerReservas();
}
