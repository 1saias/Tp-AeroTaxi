package com.company;

import com.company.Aeronaves.Aviones;

import java.time.LocalDateTime;

public class Vuelos {
    private LocalDateTime fecha;
    private  int acompañantes;
    private  int kilometros;
    private  Usuario usuario;
    private Aviones aeronave;
    private Ciudades Origen;
    private Destinos destinos;


    public Vuelos(LocalDateTime fecha, int acompañantes,int kilomentros, Usuario usuario, Aviones aeronave, Ciudades Origen, Destinos destinos) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = kilomentros;
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.Origen = Origen;
        this.destinos = destinos;
    }

    public int TotalDeKm(Ciudades origen,Destinos destinos) {
        if (origen.equals(destinos) )
        {
            System.out.println("Ingrese un destino valido");

        }
    }

    public enum Ciudades{
        BsAs,Cordoba,Montevideo
    }
    public enum Destinos{
        Cordoba,Santiago,Montevideo
    }

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

    @Override
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", acompañantes=" + acompañantes +
                ", kilometros=" + kilometros +
                ", usuario=" + usuario +
                ", aeronave=" + aeronave +
                ", ciudades=" + Origen +
                ", destinos=" + destinos +
                '}';
    }
}
