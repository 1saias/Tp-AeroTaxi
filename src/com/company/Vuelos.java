package com.company;

import com.company.Aeronaves.Aviones;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vuelos {
    private LocalDateTime fecha;
    private  int acompañantes;
    private  int kilometros=0;
    private  Usuario usuario;
    private Aviones aeronave;
    private float importe;
    private Destino destino;
    private Origen origen;

    public Vuelos(LocalDateTime fecha, int acompañantes, Usuario usuario, Aviones aeronave, Destino destino, Origen origen) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = CantidadDeKms(origen,destino);
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.importe = CalcularCostoTotal(kilometros,aeronave,acompañantes);
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

    public int CantidadDeKms(Origen origen,Destino destino){
        if (origen == Origen.BsAs) {
            if (destino == Destino.Cordoba)
            {
                {
                    this.kilometros = 695;
                }

            }else if(destino == Destino.Montevideo){

                this.kilometros = 950;

            }else if(destino == Destino.Santiago)
            {
                this.kilometros = 1400;
            }

        }else if(origen == Origen.Cordoba){

            if(destino == Destino.Montevideo){

                this.kilometros = 1190;

            }else  if(destino == Destino.Santiago) {
                this.kilometros = 1050;
            }
        }else if(origen == Origen.Montevideo && destino == Destino.Santiago)
        {
            this.kilometros = 2100;
        }
        if(this.kilometros == 0) {
            System.out.println("Ingrese un destino valido");
        }
        return this.kilometros;
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
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", kilometros=" + kilometros +
                ", aeronave=" + aeronave +
                ", acompañantes=" + acompañantes +
                ", importe=" + importe +
                ", destino=" + destino +
                ", origen=" + origen +
                ", usuario=" + usuario +
                '}';
    }
}
