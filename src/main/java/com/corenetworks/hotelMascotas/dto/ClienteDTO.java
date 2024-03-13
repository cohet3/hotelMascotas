package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.modelo.Factura;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private int idCliente;
    @NotEmpty
    @Size(min=3,max=60)
    private String nombre;
    @NotNull
    private String direccion;
    @Size(min = 9,max = 9)
    private String telefono;

    private List<Mascota> mascotas;
    private List<Factura> facturas;

    public Cliente castCliente(){

        Cliente c1= new Cliente();
        c1.setIdCliente(idCliente);
        c1.setNombre(nombre);
        c1.setDireccion(direccion);
        c1.setTelefono(telefono);
        return c1;
    }
    public ClienteDTO castClienteDto(Cliente c){
        idCliente=c.getIdCliente();
        nombre=c.getNombre();
        direccion=c.getDireccion();
        telefono=c.getTelefono();
        mascotas=c.getMascotas();
        facturas=c.getFacturas();
        return this;

    }
}

