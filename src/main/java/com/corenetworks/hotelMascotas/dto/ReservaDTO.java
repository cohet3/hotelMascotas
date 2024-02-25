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
    private Mascota mascota;

    private Habitacion habitacion;

    public Reserva castReserva(){
        Reserva r1=new Reserva();
        r1.setIdReserva(idReserva);
        r1.setFechaEntrada(fechaEntrada);
        r1.setFechaSalida(fechaSalida);
        r1.setPrecio(precio);
        r1.setMascota(mascota);
        r1.setHabitacion(habitacion);
        return r1;
    }
    public ReservaDTO castReservaDTO(Reserva r){
        idReserva=r.getIdReserva();
        fechaEntrada=r.getFechaEntrada();
        fechaSalida=r.getFechaSalida();
        precio=r.getPrecio();
        mascota=r.getMascota();
        habitacion=r.getHabitacion();
        return this;

    }

}

