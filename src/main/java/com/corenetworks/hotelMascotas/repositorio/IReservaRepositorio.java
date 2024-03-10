package com.corenetworks.hotelMascotas.repositorio;

import com.corenetworks.hotelMascotas.dto.ObtenerFechasDTO;
import com.corenetworks.hotelMascotas.modelo.Mascota;import com.corenetworks.hotelMascotas.modelo.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservaRepositorio extends IGenericoRepositorio<Reserva,Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value= "Insert into reservas_mascotas_habitaciones (fecha_entrada,fecha_salida,precio,id_mascota,id_habitacion) values (:fecha_entrada,:fecha_salida,:precio,:id_mascota,:id_habitacion)" ,nativeQuery = true)
    public Integer insert1Reserva(@Param("fecha_entrada")LocalDate fecha_entrada,@Param("fecha_salida")LocalDate fecha_salida,@Param("precio")double precio,@Param("id_mascota")int idMascota,@Param("id_habitacion")int idHabitacion);
    @Query(value = "FROM Reserva r WHERE r.fechaEntrada >= :f1 AND r.fechaSalida <= :f2")
    public List<Reserva> obtenerReservas(@Param("f1") LocalDate f1,@Param("f2") LocalDate f2);


}
