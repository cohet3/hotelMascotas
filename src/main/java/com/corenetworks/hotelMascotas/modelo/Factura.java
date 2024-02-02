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
@Table(name= "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;



    @ManyToOne
    @JoinColumn(name= "idCliente", nullable = false, foreignKey = @ForeignKey(name= "FK_factura_cliente"))
    private Cliente cliente;


}
