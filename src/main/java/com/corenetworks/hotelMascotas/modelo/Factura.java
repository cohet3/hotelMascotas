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
@Table(name= "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "idCliente", nullable = true, foreignKey = @ForeignKey(name= "FK_factura_cliente"))
    private Cliente cliente;
    @JsonIgnore
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<DetalleFactura> detalleFacturas;

}
