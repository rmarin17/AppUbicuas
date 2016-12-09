package com.example.ricardom.tet2016.models;

/**
 * Created by RicardoM on 04/10/2016.
 */

public class Ponente {
    String nombre, estudios, experiencia, formacioninternacional, habilidad, imagen,empresa;
    long id;
    //Image imagen;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getFormacioninternacional() {
        return formacioninternacional;
    }

    public void setFormacioninternacional(String formacioninternacional) {
        this.formacioninternacional = formacioninternacional;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
