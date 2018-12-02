package com.example.ana_molina.practica4;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.io.Serializable;
import java.util.Date;

public class Foto implements Serializable {

    private String nombre_foto="";
    private String nombre_descriptivo="";
    private String lugar="";
    private Date fecha;
    private String descripcion="";
    private String personas_animales_etc="";
    private byte[] foto = null;

    public Foto(String nombre_foto, String nombre_descriptivo, String lugar, Date fecha, String descripcion, String personas_animales_etc, byte[] foto) {
        this.nombre_foto = nombre_foto;
        this.nombre_descriptivo = nombre_descriptivo;
        this.lugar = lugar;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.personas_animales_etc = personas_animales_etc;
        this.foto = foto;
    }

    public String getNombre_foto() {
        return nombre_foto;
    }

    public void setNombre_foto(String nombre_foto) {
        this.nombre_foto = nombre_foto;
    }

    public String getNombre_descriptivo() {
        return nombre_descriptivo;
    }

    public void setNombre_descriptivo(String nombre_descriptivo) {
        this.nombre_descriptivo = nombre_descriptivo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPersonas_animales_etc() {
        return personas_animales_etc;
    }

    public void setPersonas_animales_etc(String personas_animales_etc) {
        this.personas_animales_etc = personas_animales_etc;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}