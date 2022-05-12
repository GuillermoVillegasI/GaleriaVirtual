package com.GaleriaVirtual.entidades;

import com.GaleriaVirtual.entidades.enumeracion.Categoria;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Obra {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String titulo;
    private String tamanio;
    private String artista;
    private String descripcion;
    private Integer anio;
    private Integer cantidad;
    private Integer vendido;
    private float precio;
    private boolean estado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;
    @OneToOne
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @OneToMany
    private Foto foto;
    @ManyToOne
    private Usuario usuario;

    public Obra() {
    }

    public Obra(String id, String titulo, Usuario usuario, Foto foto, String tamanio, String artista, String descripcion, Integer anio, Integer cantidad, float precio, boolean estado, Date alta, Categoria categoria, Integer vendido) {
        this.id = id;
        this.titulo = titulo;
        this.tamanio = tamanio;
        this.artista = artista;
        this.descripcion = descripcion;
        this.anio = anio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
        this.alta = alta;
        this.categoria = categoria;
        this.vendido = vendido;
        this.usuario = usuario;
        this.foto = foto;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }
    
    public Categoria getCategoria(){
        return categoria;
    }
    
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public Integer getVendido() {
        return vendido;
    }

    public void setVendido(Integer vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "Obra{" + "id=" + id + ", titulo=" + titulo + ", tamanio=" + tamanio + ", artista=" + artista + ", descripcion=" + descripcion + ", anio=" + anio + ", cantidad=" + cantidad + ", vendido=" + vendido + ", precio=" + precio + ", estado=" + estado + ", alta=" + alta + ", categoria=" + categoria + ", foto=" + foto + ", usuario=" + usuario + '}';
    }


    

    
    
}
