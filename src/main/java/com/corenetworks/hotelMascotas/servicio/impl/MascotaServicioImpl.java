package com.corenetworks.hotelMascotas.servicio.impl;

import com.corenetworks.hotelMascotas.modelo.Mascota;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IMascotaRepositorio;
import com.corenetworks.hotelMascotas.servicio.IMascotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServicioImpl extends CRUDImpl<Mascota,Integer>implements IMascotaServicio {
    @Autowired
    private IMascotaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Mascota, Integer> getRepo() {
        return repo;
    }
}
