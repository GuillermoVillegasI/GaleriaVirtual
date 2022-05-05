
package com.GaleriaVirtual.repositorios;

import com.GaleriaVirtual.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{

   @Query("SELECT u FROM Usuario u WHERE u.id LIKE :Id")
   public UsuarioRepositorio buscarPorId(@Param("id")String id);
   
   @Query("SELECT u FROM Usuario u WHERE u.mail LIKE :Mail")
   public UsuarioRepositorio buscarPorMail(@Param("mail")String mail);
}
