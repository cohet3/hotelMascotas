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
    private  Cliente cliente;
    public Factura castFactura(){
        Factura f1= new Factura();
        f1.setIdFactura(idFactura);
        f1.setCliente(cliente);
        return f1;
    }
    public FacturaDTO castFacturaDto(Factura f){
        idFactura=f.getIdFactura();
        cliente=f.getCliente();
        return this;
    }
}
