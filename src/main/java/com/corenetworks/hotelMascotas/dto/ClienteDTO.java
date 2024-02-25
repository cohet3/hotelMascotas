package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Max(9)
    private String telefono;


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
        return this;

    }
}

