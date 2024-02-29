package com.corenetworks.hotelMascotas.repositorio;

import com.corenetworks.hotelMascotas.modelo.Mascota;import com.corenetworks.hotelMascotas.modelo.Reserva;

public interface IReservaRepositorio extends IGenericoRepositorio<Reserva,Integer> {
    //crear aqui la query de reserva
    //tambien hay que realizarle un dto personalizado con los atributos que queremos
}
