package com.GaleriaVirtual.controladores;

import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foto")
public class FotoControlador {

// @Autowired
//private UsuarioServicio usuarioServicio;
 /*   @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> fotoUsuario(@PathVariable String id) {
        try {
            /*Usuario usuario = usuarioServicio.buscarPorId(id);   
            if (usuario.getFoto() == null) {
                
             throw new Exception("El usuario no tiene una foto asignada");
                
            } 
            // byte[] foto = usuario.getFoto().getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
//           return new ResponseEntity<>(foto, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    } */
    
    /*

    @GetMapping("/obra/{id}")
    public ResponseEntity<byte[]> fotoObra(@PathVariable String id) {
        try {
            /*Obra obra = obraServicio.buscarPorId(id);   
            if (obra.getFoto() == null) {
                
             throw new Exception("La obra no tiene una foto asignada");
                
            } 
            // byte[] foto = msdcota.getFoto().getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
//           return new ResponseEntity<>(foto, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
*/
    
   
} 
