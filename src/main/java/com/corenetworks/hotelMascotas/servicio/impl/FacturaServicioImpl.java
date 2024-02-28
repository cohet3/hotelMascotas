package com.corenetworks.hotelMascotas.servicio.impl;

import com.corenetworks.hotelMascotas.modelo.DetalleFactura;
import com.corenetworks.hotelMascotas.modelo.Factura;
import com.corenetworks.hotelMascotas.repositorio.IDetalleFacturaRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IFacturaRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.servicio.IDetalleFacturaServicio;
import com.corenetworks.hotelMascotas.servicio.IFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServicioImpl extends CRUDImpl<Factura,Integer>implements IFacturaServicio {
    @Autowired
    private IFacturaRepositorio repo;
    @Override
    protected IGenericoRepositorio<Factura, Integer> getRepo(){
        return repo;
    }

}
