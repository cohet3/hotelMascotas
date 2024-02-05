package com.corenetworks.hotelMascotas.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    @Column(length = 60)
    private String nombre;
    @Column(length = 120)
    private String direccion;
    @Column(length = 9)
    private String telefono;

//en caso de no necesitarlo para front, fuera linea 28
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Mascota> mascotas;
    //en caso de no necesitarlo para front, fuera linea 31
    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Factura> facturas;
}
