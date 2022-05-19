package com.GaleriaVirtual.controladores;

import com.GaleriaVirtual.entidades.Obra;
import com.GaleriaVirtual.entidades.enumeracion.Categoria;
import com.GaleriaVirtual.errores.ErrorServicio;
import com.GaleriaVirtual.servicios.ObraServicio;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/obra")
    public String obra() {
        return "obra.html";
    }

    @PostMapping("/obra")
    public String subirObra(ModelMap modelo, @RequestParam String titulo, @RequestParam String tamanio, @RequestParam String artista,
            @RequestParam String descripcion, @RequestParam Integer anio, @RequestParam Integer cantidad, @RequestParam Integer vendido,
             @RequestParam float precio) {

        try {
            //obraServicio.guardar(titulo, tamanio, artista, descripcion, anio, cantidad, tamanio,estado );
        } catch (Exception e) {
            //msj de error
        }
        return "/obra";

    }

    @PostMapping("/crear")
    public String guardar(ModelMap modelo, @RequestParam String titulo, @RequestParam String tamanio, @RequestParam String artista,
            @RequestParam String descripcion, @RequestParam Integer anio, @RequestParam Integer cantidad,
            @RequestParam float precio, @RequestParam boolean estado, @RequestParam Date date,
            @RequestParam Categoria categoria, MultipartFile archivo, String UsuarioId) throws ErrorServicio {

        try {
            obraServicio.guardar(titulo, tamanio, artista, descripcion, anio, cantidad, precio, estado, date, categoria, archivo, UsuarioId);
        } catch (ErrorServicio ex) {
            modelo.put("errorReg", ex.getMessage());
            modelo.put("titulo", titulo);
            modelo.put("tamanio", tamanio);
            modelo.put("artista", artista);
            modelo.put("descripcion", descripcion);
            modelo.put("anio", anio);
            modelo.put("cantidad", cantidad);
            modelo.put("precio", precio);
            //   modelo.put("estado", estado);
            //   modelo.put("date", date);
            modelo.put("categoria", categoria);
            modelo.put("archivo", archivo);
            //   modelo.put("UsuarioId", UsuarioId);
            return "registro.html";
        }
        modelo.put("titulo", "Tu obra fue cargada con Exito!");
        return "/obras.html";

    }

  
}
