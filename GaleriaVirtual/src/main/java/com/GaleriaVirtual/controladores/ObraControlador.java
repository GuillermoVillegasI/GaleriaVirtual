package com.GaleriaVirtual.controladores;

import com.GaleriaVirtual.entidades.enumeracion.Categoria;
import com.GaleriaVirtual.servicios.ObraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam String descripcion, @RequestParam Integer anio, @RequestParam Integer cantidad, @RequestParam Integer vendido
    , @RequestParam float precio){
        
        try {
            //obraServicio.guardar(titulo, tamanio, artista, descripcion, anio, cantidad, tamanio,estado );
        } catch (Exception e) {
            //msj de error
        }        
        return "/obra";
        
    }
}
