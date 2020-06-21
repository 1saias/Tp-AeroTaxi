package com.company;

import com.company.Aeronaves.Aviones;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelos {
    private LocalDateTime fecha;
    private  int acompañantes;
    private  int kilometros;
    private  Usuario usuario;
    private Aviones aeronave;
    private float importe;
    private Destino destino;
    private Origen origen;

    public enum Destino{
        Cordoba,Montevideo,Santiago;

    }
    public enum  Origen {
        BsAs, Cordoba, Montevideo;
    }

    public void setFecha(LocalDateTime fecha){
        this.fecha = fecha;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
    }
    public int getAcompañantes() {
        return acompañantes;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }
    public int getKilometros() {
        return kilometros;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setAeronave(Aviones aeronave) {
        this.aeronave = aeronave;
    }
    public Aviones getAeronave() {
        return aeronave;
    }


    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    public Destino getDestino() {
        return destino;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }
    public Origen getOrigen() {
        return origen;
    }


    public Vuelos(LocalDateTime fecha, int acompañantes,int kilomentros, Usuario usuario, Aviones aeronave, Ciudades Origen, Destinos destinos) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = kilomentros;
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.Origen = Origen;
        this.destinos = destinos;
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

    /*public boolean comprobacionfecha(ArrayList<Vuelos> vuelos, LocalDateTime seleccion){
        for(Vuelos aux : vuelos ){
            if()
        }
    }*/


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
    private Ciudades Origen;
    private Destinos destinos;




   /* public int TotalDeKm(Ciudades origen,Destinos destinos) {
        if (origen.equals(destinos) )
        {
            System.out.println("Ingrese un destino valido");
>>>>>>> bb2c62fa909ab1f4aba4041e8880d14a95138755

        }
    }*/

    public enum Ciudades{
        BsAs,Cordoba,Montevideo
    }
    public enum Destinos{
        Cordoba,Santiago,Montevideo
    }

}
