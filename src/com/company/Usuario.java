package com.company;

import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    private List<Vuelos> vuelosList;

///CONSTRUCTOR
    public Usuario(String nombre,String apellido,int dni,int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }
///COMPARACION
@Override
public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Usuario)) return false;
    Usuario us = (Usuario) obj;
    return this.nombre.equalsIgnoreCase(us.nombre) && this.apellido.equalsIgnoreCase(us.apellido)
            && this.dni == us.dni && this.edad ==us.edad;
}
///MOSTRAR
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                '}';
    }
///SET AND GET
public void setNombre(String nombre) {
    this.nombre = nombre;
}
    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return this.apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    public float getDni() {
        return this.dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getEdad() {
        return this.edad;
    }

    public List<Vuelos> getVuelosList() {
        return vuelosList;
    }
    public void setVuelosList(List<Vuelos> vuelosList) {
        this.vuelosList = vuelosList;
    }
}

