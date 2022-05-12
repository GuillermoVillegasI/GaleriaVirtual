package com.GaleriaVirtual.repositorios;

import com.GaleriaVirtual.entidades.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepositorio extends JpaRepository<Obra, String> {

}
