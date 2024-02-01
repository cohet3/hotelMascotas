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
    @Column(length = 60,nullable = false)
    private String nombre;
    @Column(length = 50,nullable = false)
    private String raza;
    @Column(nullable = false)
    private int edad;
    @Column(length = 30,nullable = false)
    private String tamano;
    @Column (length = 30,nullable = false)
    private String tipoHabitacion;

    @OneToMany(mappedBy = "mascota",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name= "idCliente", nullable = false, foreignKey = @ForeignKey(name= "FK_mascota_cliente"))
    private Cliente cliente;

}
