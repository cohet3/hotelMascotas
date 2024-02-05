package com.corenetworks.hotelMascotas.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor@Data
public class ExcepcionRespuesta {
    private LocalDateTime fecha;
    private String mensaje;
    private String detalle;

}
