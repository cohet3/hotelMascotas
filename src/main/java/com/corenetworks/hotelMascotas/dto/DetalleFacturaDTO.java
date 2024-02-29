package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDTO {
    private int idDetalleFactura;
    @NotEmpty
    private String concepto;
    @NotNull
    private LocalDate fechaFactura;
    @Min(1)
    @Max(250)
    private double precio;
    //desde aqui
    private int idFactura;
    private int idHabitacion;
    private int idReserva;
    private int idMascota;
    private int idServicio;

    public DetalleFactura castDetalleFactura(){

        DetalleFactura dF1= new DetalleFactura();
        dF1.setIdDetalleFactura(idDetalleFactura);
        dF1.setConcepto(concepto);
        dF1.setFechaFactura(fechaFactura);
        dF1.setPrecio(precio);
        return dF1;
    }
    public DetalleFacturaDTO castDetalleFacturaDto(DetalleFactura dF){
        idDetalleFactura=getIdDetalleFactura();
        concepto=getConcepto();
        fechaFactura=getFechaFactura();
        precio=getPrecio();
        idFactura=getIdFactura();
        idHabitacion=getIdHabitacion();
        idReserva= getIdReserva();
        idMascota= getIdMascota();
        idServicio=getIdServicio();
        return this;

    }

}
