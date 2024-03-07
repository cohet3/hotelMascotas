package com.corenetworks.hotelMascotas.dto;

import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.modelo.Mascota;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {
    private int idMascota;
    private String nombre;
    private String raza;
    private int edad;
    private String tamano;
    private String tipoHabitacion;
    private int idCliente;
    public Mascota castMascota(){
        Mascota m1=new Mascota();
        m1.setIdMascota(idMascota);
        m1.setNombre(nombre);
        m1.setEdad(edad);
        m1.setRaza(raza);
        m1.setTamano(tamano);
        m1.setTipoHabitacion(tipoHabitacion);
     //   c1.setIdCliente(idCliente);

        return m1;
    }
    public MascotaDTO castMascotaDTO(Mascota m){
        idMascota=m.getIdMascota();
        nombre=m.getNombre();
        edad=m.getEdad();
        raza=m.getRaza();
        tamano=m.getTamano();
        tipoHabitacion=m.getTipoHabitacion();
        return this;
    }
}

