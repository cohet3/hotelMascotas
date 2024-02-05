package com.corenetworks.hotelMascotas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericoRepositorio<T,ID> extends JpaRepository<T,ID> {
}
