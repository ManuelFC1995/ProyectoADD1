/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.List;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String foto;
    private Object unknow;
    private ArrayList<List> MisListas;
    private ArrayList<List> ListaSuscripcion;
    
    
    public Usuario(int id, String nombre, String correo,String foto, Object unknow ) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.foto = foto;
        this.unknow=unknow;
        this.MisListas=null;
        this.ListaSuscripcion=null;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Object getUnknow() {
        return unknow;
    }

    public void setUnknow(Object unknow) {
        this.unknow = unknow;
    }

    public ArrayList<List> getMisListas() {
        return MisListas;
    }

    public void setMisListas(ArrayList<List> MisListas) {
        this.MisListas = MisListas;
    }

    public ArrayList<List> getListaSuscripcion() {
        return ListaSuscripcion;
    }

    public void setListaSuscripcion(ArrayList<List> ListaSuscripcion) {
        this.ListaSuscripcion = ListaSuscripcion;
    }
    
    
}
