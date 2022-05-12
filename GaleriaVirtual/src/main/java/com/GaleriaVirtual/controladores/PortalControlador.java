package com.GaleriaVirtual.controladores;

import com.GaleriaVirtual.errores.ErrorServicio;
import com.GaleriaVirtual.servicios.UsuarioServicio;
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

@Controller
@RequestMapping()
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping()
    public String index() {
        return "index2.html";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro.html";
    }

    @PostMapping("/registrar")
    public String registrar(ModelMap modelo, @RequestParam String nickname, @RequestParam String mail, @RequestParam String contrasenia1, @RequestParam String contrasenia2) {

        try {
            usuarioServicio.registrar(nickname, mail, contrasenia1, contrasenia2);
        } catch (ErrorServicio ex) {
            modelo.put("errorReg", ex.getMessage());
            modelo.put("nickname", nickname);
            modelo.put("mail", mail);
            modelo.put("contrasenia1", contrasenia1);
            modelo.put("contrasenia2", contrasenia2);
            return "registro.html";
        }
        modelo.put("titulo", "Bienvenido a la Galería de Arte Tamago!");
        modelo.put("descripcion", "Logeate para comenzar");
        return "/";

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap model) {
        if (error != null) {
            model.put("error", "Usuario o contraseña incorrecta  .");
        }
        return "login.html";
    }

//    @PreAuthorize("hasAnyRol('ROL_USER_REGISTRADO')")
//    @GetMapping("/comprar")
//    public String comprar() {
//        return "comprar.html";
//    }
//    
//    @PreAuthorize("hasAnyRol('ROL_USER_REGISTRADO')")
//    @GetMapping("/vender")
//    public String vender() {
//        return "vender.html";
//    }
    
}
