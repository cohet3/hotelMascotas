package com.corenetworks.hotelMascotas.servicio.impl;


import com.corenetworks.hotelMascotas.modelo.Cliente;
import com.corenetworks.hotelMascotas.repositorio.IClienteRepositorio;
import com.corenetworks.hotelMascotas.repositorio.IGenericoRepositorio;
import com.corenetworks.hotelMascotas.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl extends CRUDImpl<Cliente,Integer>implements IClienteServicio {
    @Autowired
    private IClienteRepositorio repo;
    @Override
    protected IGenericoRepositorio<Cliente, Integer> getRepo() {
        return repo;
    }
}
