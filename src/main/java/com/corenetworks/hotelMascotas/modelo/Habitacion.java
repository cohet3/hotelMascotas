package com.corenetworks.hotelMascotas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //25 de perros , 10 de gatos se va a limitar por número de habit y fecha
    private int idHabitacion;
    @Column(length = 60)
    private double tarifa;
    @Column(length = 150)
    private String description;
    @Column(length = 60)
    private String tipoAnimal;


    //Falta relación  con reservas

}
