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

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
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
