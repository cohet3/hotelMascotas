package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idHabitacion;
    @Column(nullable = false)
    private double tarifa;
    @Column(length = 60,nullable = false)
    private String description;
    @Column(length = 30,nullable = false)
    private String tipoHabitacion;


    @OneToMany(mappedBy = "r1",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Reserva> reservas;
}
