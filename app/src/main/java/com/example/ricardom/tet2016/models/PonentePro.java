package com.example.ricardom.tet2016.models;

/**
 * Created by RicardoM on 06/10/2016.
 */

public class PonentePro {
    String nombre, imagen;
    long id;

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
