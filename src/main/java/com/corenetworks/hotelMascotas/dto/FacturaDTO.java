package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.modelo.Factura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    private int idFactura;
    //como paso el id cliente y no el cliente entero?
    //el crud funciona pero aun no entiendo bien como vamos a pasarle el parametro idCliente
    private int idCliente;

    public Factura castFactura(){

        Factura f1= new Factura();
        f1.setIdFactura(idFactura);

        return f1;
    }
    public FacturaDTO castFacturaDto(Factura f){
        idFactura=f.getIdFactura();


        return this;

    }
}
