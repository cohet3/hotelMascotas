package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Habitacion;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.modelo.Reserva;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private int idReserva;
    @NotEmpty
    private LocalDate fechaEntrada;
    @NotEmpty
    private LocalDate fechaSalida;
    @Min(1)
    @Max(40)
    private double precio;
    private Integer idHabitacion;
    private Integer idMascota;

    public Reserva castReserva(){
        Reserva r1=new Reserva();
        Habitacion h1= new Habitacion();
        Mascota m1= new Mascota();
        r1.setIdReserva(idReserva);
        r1.setFechaEntrada(fechaEntrada);
        r1.setFechaSalida(fechaSalida);
        r1.setPrecio(precio);
        m1.setIdMascota(idMascota);
        h1.setIdHabitacion(idHabitacion);
        return r1;
    }
    public ReservaDTO castReservaDTO(Reserva r){
        Habitacion h1= new Habitacion();
        Mascota m1= new Mascota();
        idReserva=r.getIdReserva();
        fechaEntrada=r.getFechaEntrada();
        fechaSalida=r.getFechaSalida();
        precio=r.getPrecio();
        idMascota= m1.getIdMascota();
        idHabitacion=h1.getIdHabitacion();
        return this;

    }

}

