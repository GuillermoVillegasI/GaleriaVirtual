package com.GaleriaVirtual.controladores;

import com.GaleriaVirtual.errores.ErrorServicio;
import com.GaleriaVirtual.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
            
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
    
     @GetMapping("/login")
    public String login() {
        return "login.html";      
    } 
    
    @GetMapping("/registro")
    public String registro() {
        return "registro.html";  
    }
    
    @PostMapping("/registrar")
    public String registrar(@RequestParam String nickname, @RequestParam String mail, @RequestParam String contrasenia1,@RequestParam String contrasenia2){
        
        try {
            usuarioServicio.registrar(nickname, mail, contrasenia1);
        } catch (ErrorServicio ex) {
            Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "registro.html";
        }
        return "login.html";       
        
    }
}





















