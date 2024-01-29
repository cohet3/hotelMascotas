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
@Table(name= "mascotas")

public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMascota;
    @Column(length = 60)
    private String nombre;
    @Column(length = 60)
    private String raza;
    @Column (nullable = false)
    private int edad;
    @Column(length = 60)
    private String tamano;
    @Column(length = 60)
    private String tipoMascota;

    //@OneToMany
    //un list de reserva
    //falta la relación
/*    @OneToMany(mappedBy = "editorial",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<> libros;*/
}
