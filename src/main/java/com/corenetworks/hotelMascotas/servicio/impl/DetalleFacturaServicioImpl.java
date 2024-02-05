package com.corenetworks.hotelMascotas.servicio.impl;

import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
import com.corenetworks.hotelMascotas.repositorio.IDetalleFacturaRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;

import com.corenetworks.hotelMascotas.servicio.IDetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServicioImpl extends CRUDImpl<DetalleFactura,Integer>implements IDetalleFacturaServicio {
    @Autowired
    private IDetalleFacturaRepositorio repo;
    @Override
    protected IGenericoRepositorio<DetalleFactura, Integer> getRepo(){
        return repo;
    }
}
