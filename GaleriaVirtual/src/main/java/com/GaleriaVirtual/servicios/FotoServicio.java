package com.GaleriaVirtual.servicios;

import com.GaleriaVirtual.entidades.Foto;
import com.GaleriaVirtual.errores.ErrorServicio;
import com.GaleriaVirtual.repositorios.FotoRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoServicio {

    @Autowired
    private FotoRepositorio fotoRepositorio;

    @Transactional(rollbackFor = {Exception.class})
    public Foto guardar(MultipartFile archivo) throws Exception {

        if (archivo != null && !archivo.isEmpty()) {
            try {
                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Transactional(rollbackFor = {Exception.class})
    public Foto actualizar(String idFoto, MultipartFile archivo) throws Exception {
        if (archivo != null) {
            try {
                Foto foto = new Foto();
                if (idFoto != null) {
                    Optional<Foto> respuesta = fotoRepositorio.findById(idFoto);
                    if (respuesta.isPresent()) {
                        foto = respuesta.get();
                    }
                }
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deshabilitar(String id) throws Exception {
        Optional<Foto> respuesta = fotoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Foto foto = respuesta.get();
            foto.setAlta(false);
            fotoRepositorio.save(foto);

        } else {
            throw new Exception("La foto no existe");
        }
    }

    @Transactional(readOnly = true)
    public Foto buscarPorId(String id) throws Exception {
        Optional<Foto> respuesta = fotoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            return respuesta.get();
        } else {
            throw new Exception("La foto no existe.");
        }
    }
}
