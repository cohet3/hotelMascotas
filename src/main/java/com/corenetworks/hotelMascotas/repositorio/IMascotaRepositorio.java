package com.corenetworks.hotelMascotas.repositorio;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMascotaRepositorio extends IGenericoRepositorio<Mascota,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query( value = "Insert into mascotas (edad,nombre,raza,tamano,tipo_habitacion,id_cliente) values (:edad,:nombre,:raza,:tamano,:tipo_habitacion,:id_cliente)",nativeQuery = true )
    public Integer insertaUnaMascota (@Param("edad") int edad, @Param("nombre") String nombre, @Param("raza")String raza, @Param("tamano")String tamano, @Param("tipo_habitacion")String tipo_habitacion, @Param("id_cliente")int idCliente);
}
