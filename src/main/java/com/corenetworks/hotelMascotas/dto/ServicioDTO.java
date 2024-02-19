package com.corenetworks.hotelMascotas.dto;
import com.corenetworks.hotelMascotas.modelo.Servicio;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ServicioDTO {
    private int idServicio;
@NotEmpty
@Size(min=3,max=60)
    private String concepto;
@Min(3)
@Max(200)
    private double precio;

  public Servicio castServicio(){
   Servicio s1= new Servicio();
   s1.setIdServicio(idServicio);
   s1.setConcepto(concepto);
   s1.setPrecio(precio);
   return s1;
  }
  public ServicioDTO castServicioADto(Servicio s){
      idServicio=s.getIdServicio();
      concepto=s.getConcepto();
      precio=s.getPrecio();
      return this;
  }
}
