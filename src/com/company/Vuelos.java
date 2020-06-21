package com.company;

import com.company.Aeronaves.Aviones;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vuelos {
    private LocalDateTime fecha;
    private  int acompañantes;
    private  int kilometros;
    private  Usuario usuario;
    private Aviones aeronave;
    private float importe;
    private Destino destino;
    private Origen origen;

    public Vuelos(LocalDateTime fecha, int acompañantes, int kilometros, Usuario usuario, Aviones aeronave, float importe, Destino destino, Origen origen) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = kilometros;
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.importe = importe;
        this.destino = destino;
        this.origen = origen;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getAcompañantes() {
        return acompañantes;
    }

    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
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

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public enum Destino{
        Cordoba,Montevideo,Santiago;

    }

    public enum  Origen{
        BsAs,Cordoba,Montevideo;
    }

    public float CalcularCostoTotal(int kilomentros,Aviones aeronave,int acompañantes){
        float total = (kilomentros * aeronave.getCostoXKM())+
                ((acompañantes+1)*3500) + (aeronave.getTarifa());
        return total;
    }

    /*public int disponibilidad(ArrayList vuelos,Vuelos enProceso){

        ///usamos equals?
    }*/

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof Vuelos))return false;
        Vuelos vl=(Vuelos)obj;
        return this.fecha.equals(vl.fecha) && this.acompañantes == vl.acompañantes &&
                this.kilometros == vl.kilometros && this.usuario.equals(usuario) &&
                this.aeronave.equals(aeronave);
    }



    @Override
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", acompañantes=" + acompañantes +
                ", kilomentros=" + kilometros +
                ", usuario=" + usuario +
                ", aeronave=" + aeronave +
                '}';
    }

}
