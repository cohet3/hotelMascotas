package com.corenetworks.hotelMascotas.repositorio;

import com.corenetworks.hotelMascotas.modelo.Mascota;import com.corenetworks.hotelMascotas.modelo.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservaRepositorio extends IGenericoRepositorio<Reserva,Integer> {
    //crear aqui la query de reserva
    //tambien hay que realizarle un dto personalizado con los atributos que queremos
//    @Query(value = "SELECT r FROM Reserva WHERE r.fechaEntrada >= :f1 AND r.fechaSalida <= :f2;")
//    public List<Reserva> obtenerReservas(@Param("f1") LocalDate f1,@Param("f2") LocalDate f2);
    @Query(value = "FROM Reserva r WHERE r.fechaEntrada >= :f1 AND r.fechaSalida <= :f2")
    public List<Reserva> obtenerReservas(@Param("f1") LocalDate f1,@Param("f2") LocalDate f2);
}
