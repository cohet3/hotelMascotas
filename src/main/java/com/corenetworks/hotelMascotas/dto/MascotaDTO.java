package com.corenetworks.hotelMascotas.dto;

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
    @NotEmpty
    @Size(min=3,max=69)
    private String nombre;
    @NotNull
    private String raza;
    @NotEmpty
    private int edad;
    @NotEmpty
    private String tamano;
    @NotEmpty
    private String tipoHabitacion;

    public Mascota castMascota(){
        Mascota m1=new Mascota();
        m1.setIdMascota(idMascota);
        m1.setNombre(nombre);
        m1.setEdad(edad);
        m1.setTamano(tamano);
        m1.setTipoHabitacion(tipoHabitacion);
        return m1;
    }
    public MascotaDTO castMascotaDTO(Mascota m){
        idMascota=m.getIdMascota();
        nombre=m.getNombre();
        edad=m.getEdad();
        tamano=m.getTamano();
        tipoHabitacion=m.getTipoHabitacion();
        return this;
    }
}

