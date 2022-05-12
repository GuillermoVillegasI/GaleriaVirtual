package com.GaleriaVirtual.repositorios;

import com.GaleriaVirtual.entidades.Obra;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepositorio extends JpaRepository<Obra, String> {

    public Optional<Obra> findAllById(String id);
    
    @Query("SELECT o FROM Obra o  WHERE o.id LIKE :id")
    public ObraRepositorio buscarPorId(@Param("id")String id);
}
