package com.curso.cdi;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class UsuarioBean implements Serializable{
    
    private String nombre;
    private String rol;

    public UsuarioBean() {
        System.out.println(".... instanciando UsuarioBean");
    }
    
   
    public UsuarioBean(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
