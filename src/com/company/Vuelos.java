package com.company;

import com.company.Aeronaves.Aviones;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vuelos {
    private LocalDateTime fecha;
    private  int acompañantes;
    private  int kilomentros;
    private  Usuario usuario;
    private Aviones aeronave;
    private float importe;


    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getAcompañantes() {
        return acompañantes;
    }
    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
    }

    public int getKilomentros() {
        return kilomentros;
    }
    public void setKilomentros(int kilomentros) {
        this.kilomentros = kilomentros;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aviones getAeronave() {
        return aeronave;
    }
    public void setAeronave(Aviones aeronave) {
        this.aeronave = aeronave;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Vuelos(ArrayList vuelos, LocalDateTime fecha, int acompañantes, int kilomentros, Usuario usuario, Aviones aeronave){
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilomentros = kilomentros;
        this.usuario = usuario;
        this.aeronave = aeronave;
    }

    public float CalcularCostoTotal(int kilomentros,Aviones aeronave,int acompañantes){
        float total = (kilomentros * aeronave.getCostoXKM())+
                ((acompañantes+1)*3500) + (aeronave.getTarifa());
        return total;
    }

    /*public int disponibilidad(ArrayList vuelos,Vuelos enProceso){

        ///usamos equals?
    }*/

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof Vuelos))return false;
        Vuelos vl=(Vuelos)obj;
        return this.fecha.equals(vl.fecha) && this.acompañantes == vl.acompañantes &&
                this.kilomentros == vl.kilomentros && this.usuario.equals(usuario) &&
                this.aeronave.equals(aeronave);
    }



    @Override
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", acompañantes=" + acompañantes +
                ", kilomentros=" + kilomentros +
                ", usuario=" + usuario +
                ", aeronave=" + aeronave +
                '}';
    }


}
