package com.corenetworks.hotelMascotas.dto;


import com.corenetworks.hotelMascotas.modelo.Habitacion;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {
    private int idHabitacion;
    @Min(1)
    @Max(40)
    private double tarifa;
    @NotNull
    private String description;
    @NotEmpty
    private String tipoHabitacion;

    public Habitacion castHabitacion(){

        Habitacion h1= new Habitacion();
        h1.setIdHabitacion(idHabitacion);
        h1.setTarifa(tarifa);
        h1.setDescription(description);
        h1.setTipoHabitacion(tipoHabitacion);
        return h1;
    }
    public HabitacionDTO castHabitacionDto(Habitacion h){
        idHabitacion=h.getIdHabitacion();
        tarifa=h.getTarifa();
        description=h.getDescription();
        tipoHabitacion=h.getTipoHabitacion();
        return this;

    }
}
