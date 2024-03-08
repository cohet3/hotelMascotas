package com.corenetworks.hotelMascotas.servicio;

import com.corenetworks.hotelMascotas.dto.ObtenerFechasDTO;
import com.corenetworks.hotelMascotas.modelo.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IReservaServicio extends ICRUD<Reserva,Integer> {

    List<Reserva> obtenerReservas(LocalDate f1,LocalDate f2);

}
