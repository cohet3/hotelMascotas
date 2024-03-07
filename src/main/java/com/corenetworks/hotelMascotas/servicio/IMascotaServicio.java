package com.corenetworks.hotelMascotas.servicio;

import com.corenetworks.hotelMascotas.dto.MascotaDTO;
import com.corenetworks.hotelMascotas.modelo.Mascota;

public interface IMascotaServicio extends ICRUD<Mascota,Integer> {
    public Integer insertarUnaMascota(MascotaDTO m);
}
