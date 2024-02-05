package com.corenetworks.hotelMascotas.servicio;

import java.util.List;

public interface ICRUD<T,ID>{
    List<T>listasTodos()throws Exception;
    T listarUno(ID id)throws Exception;
    T insertar(T t) throws Exception;
    T modificar(T t) throws Exception;
    void eliminar(ID id)throws Exception;
}
