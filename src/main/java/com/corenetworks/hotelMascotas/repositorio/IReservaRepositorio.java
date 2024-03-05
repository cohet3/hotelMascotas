package com.corenetworks.hotelMascotas.repositorio;

import com.corenetworks.hotelMascotas.modelo.Mascota;import com.corenetworks.hotelMascotas.modelo.Reserva;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReservaRepositorio extends IGenericoRepositorio<Reserva,Integer> {
    //crear aqui la query de reserva
    //tambien hay que realizarle un dto personalizado con los atributos que queremos
    @Query(value = "Select * from reservas_mascotas_habitaciones;",nativeQuery = true)
    public List<Object[]> obtenerReservas();
}
