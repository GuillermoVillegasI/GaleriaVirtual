
package com.GaleriaVirtual.repositorios;

import com.GaleriaVirtual.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
   
   @Query("SELECT u FROM Usuario u WHERE u.mail LIKE :mail")
   public Usuario buscarPorMail(@Param("mail") String mail);
   
}
