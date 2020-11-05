/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;


/**
 *
 * @author migue
 */
public class List {
    private int id;
    private String nombre;
    private Object descripcion;
    private Usuario Creador;
    private ArrayList<Usuario> subs;
    private ArrayList<Cancion> Canciones;
    
    
    public List(int id, String nombre, Object descripcion,Usuario Creador ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.Creador = Creador;
        this.subs=null;
        this.Canciones=null;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Object descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getCreador() {
        return Creador;
    }

    public void setCreador(Usuario Creador) {
        this.Creador = Creador;
    }

    public ArrayList<Usuario> getSubs() {
        return subs;
    }

    public void setSubs(ArrayList<Usuario> subs) {
        this.subs = subs;
    }

    public ArrayList<Cancion> getCanciones() {
        return Canciones;
    }

    public void setCanciones(ArrayList<Cancion> Canciones) {
        this.Canciones = Canciones;
    }
    
}
