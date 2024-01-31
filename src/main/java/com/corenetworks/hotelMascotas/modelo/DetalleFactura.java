package com.corenetworks.hotelMascotas.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="detalles_facturas")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleFactura;

    private String concepto;
    private double precio;
    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_clientes_detalles_facturas"))
    private Cliente cliente;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_reservas", nullable = false, foreignKey = @ForeignKey(name = "FK_reservas_detalles_facturas"))
    private Reserva reserva;
    @OneToOne
    @JoinColumn(name = "id_factura", nullable = false, foreignKey = @ForeignKey(name = "FK_facturas_detalles_facturas"))
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false, foreignKey = @ForeignKey(name = "FK_servicios_detalles_facturas"))
    private Servicio servicio;
}
