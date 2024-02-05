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
    //En caso de no necesitarlo en el front nos lo cargamos
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Mascota> mascotas;
    //En caso de que en el front tenemos una pantalla para que el cliente consulte sus facturas
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Factura> facturas;

}
