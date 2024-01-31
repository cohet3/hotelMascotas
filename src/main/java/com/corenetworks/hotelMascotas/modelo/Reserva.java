package com.corenetworks.hotelMascotas.modelo;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservas")
@IdClass(ReservaPK.class)
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    @Id
    private int idMascota;
    @Id
    private int idHabitacion;

}
