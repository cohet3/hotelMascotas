package com.corenetworks.hotelMascotas.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable


public class ReservaPK implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @ManyToOne
    @JoinColumn(name = "idMascota", nullable = false, foreignKey = @ForeignKey(name = "FK_reserva_mascota"))
    private Mascota mascota;
    //@JoinTable no se usa porque esta el PK
    @ManyToOne
    @JoinColumn(name = "idHabitacion", nullable = false, foreignKey = @ForeignKey(name = "FK_reserva_habitacion"))
    private Habitacion habitacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaPK reservaPK = (ReservaPK) o;
        return idReserva == reservaPK.idReserva && Objects.equals(mascota, reservaPK.mascota) && Objects.equals(habitacion, reservaPK.habitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, mascota, habitacion);
    }
}
