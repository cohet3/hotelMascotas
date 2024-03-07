package com.corenetworks.hotelMascotas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObtenerFechasDTO {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
}
