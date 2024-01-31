package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name="id_habitacion", nullable = false, foreignKey = @ForeignKey(name="FK_reservas_habitaciones"))
    private Habitacion habitacion;
    @ManyToOne
    @JoinColumn(name="id_mascota", nullable = false, foreignKey = @ForeignKey(name="FK_reservas_mascotas"))
    private Mascota mascota;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaPK reservaPK = (ReservaPK) o;
        return Objects.equals(habitacion, reservaPK.habitacion) && Objects.equals(mascota, reservaPK.mascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, mascota);
    }
}