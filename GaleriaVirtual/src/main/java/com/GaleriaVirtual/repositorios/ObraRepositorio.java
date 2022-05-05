package com.GaleriaVirtual.repositorios;

import com.GaleriaVirtual.entidades.Obra;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepositorio extends JpaRepository<Obra, String> {

    public Optional<Obra> findAllById(String id);
    public Obra geByID (String id);
}
