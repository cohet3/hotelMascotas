package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Factura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    private int idFactura;

    public Factura castFactura(){

        Factura f1= new Factura();
        f1.setIdFactura(idFactura);

        return f1;
    }
    public FacturaDTO castFacturaDto(Factura f){
        idFactura=getIdFactura();

        return this;

    }
}
