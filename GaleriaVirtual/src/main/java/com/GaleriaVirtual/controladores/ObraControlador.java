package com.GaleriaVirtual.controladores;

import com.GaleriaVirtual.entidades.Obra;
import com.GaleriaVirtual.entidades.enumeracion.Categoria;
import com.GaleriaVirtual.errores.ErrorServicio;
import com.GaleriaVirtual.servicios.ObraServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/obra")
public class ObraControlador {

    @Autowired
    private ObraServicio obraServicio;
    

  // @PreAuthorize("hasAnyRole('ROL_USER_REGISTRADO')")
 //   @GetMapping("/obras")
 //   public String obras() {
 //       return "obras.html";
 //   }
    
  //  @PreAuthorize("hasAnyRole('ROL_USER_REGISTRADO')")
    @PostMapping("/crear")
    public String guardar(ModelMap modelo, @RequestParam String titulo, @RequestParam String tamanio, @RequestParam String artista,
            @RequestParam String descripcion, @RequestParam Integer anio, @RequestParam Integer cantidad,
            @RequestParam float precio, @RequestParam Categoria categoria,
            @RequestParam MultipartFile archivo, @RequestParam(required = false) String idUsuario) {

        try {
            
            obraServicio.guardar(titulo, tamanio, artista, descripcion, anio, cantidad, 0, true, new Date(), categoria, archivo, idUsuario);
       
        } catch (ErrorServicio ex) {
            modelo.put("errorReg", ex.getMessage());
            modelo.put("titulo", titulo);
            modelo.put("tamanio", tamanio);
            modelo.put("artista", artista);
            modelo.put("descripcion", descripcion);
            modelo.put("anio", anio);
            modelo.put("cantidad", cantidad);
            modelo.put("precio", precio);
            modelo.put("categoria", categoria);
            modelo.put("archivo", archivo);
            return "registro.html";
        }
        modelo.put("titulo", "Tu obra fue cargada con Exito!");
          return "redirect:/index";

    }
    @GetMapping("/obras")
    public String obras(@RequestParam(required = false) String categoria, ModelMap modelo) throws ErrorServicio {

        List<Obra> obras = new ArrayList<>();

        if (categoria == null) {
            obras = obraServicio.buscarTodas();
        } else {
            Categoria parsedCategoria = Categoria.valueOf(categoria);
            obras = obraServicio.buscarPorCategoria(parsedCategoria);
        }

        modelo.put("obras", obras);

        return "obras.html";
    }
}
