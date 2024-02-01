package com.corenetworks.hotelMascotas.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservas")
/*@IdClass(ReservaPK.class)*/
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double precio;

/*    @ManyToOne
    @JoinColumn(name= "idMascota", nullable = false, foreignKey = @ForeignKey(name= "FK_reserva_mascota"))
    private Mascota m1;

    @OneToMany(mappedBy = "idHabitacion",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Habitacion> habitaciones;*/

}
