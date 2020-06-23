package com.company.Aeronaves;

import com.company.Motor;

public class Aviones {
    private String nombre;
    private int numSerie;
    private float capCombustible;
    private float costoXKM;
    private int capMXPasajeros;
    private double velMX;          //En km/h
    private Motor motor;
    private int tarifa;
    private int reservado =0;


    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSerie(){
        return this.numSerie;
    }
    public void setNumSerie(int numSerie){
        this.numSerie = numSerie;
    }

    public void setCapCombustible(float capCombustible) {
        this.capCombustible = capCombustible;
    }
    public float getCapCombustible() {
        return this.capCombustible;
    }

    public void setCostoXKM(float costoXKM) {
        this.costoXKM = costoXKM;
    }
    public float getCostoXKM() {
        return this.costoXKM;
    }

    public void setCapMXPasajeros(int capMXPasajeros) {
        this.capMXPasajeros = capMXPasajeros;
    }
    public int getCapMXPasajeros() {
        return this.capMXPasajeros;
    }

    public void setVelMX(double velMX) {
        this.velMX = velMX;
    }
    public double getVelMX() {
        return this.velMX;
    }

    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public int getTarifa() {
        return tarifa;
    }
    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getReservado() {
        return reservado;
    }
    public void setReservado(int reservado) {
        this.reservado = reservado;
    }

    public Aviones(){}

    public Aviones(String nombre,int numSerie,float capCombustible, float costoXKM, int capMXPasajeros,
                   double velMX, Motor motor,int tarifa){
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.capCombustible = capCombustible;
        this.costoXKM = costoXKM;
        this.capMXPasajeros = capMXPasajeros;
        this.velMX = velMX;
        this.motor = motor;
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Aviones{" +
                "nombre='" + nombre + '\'' +
                ", numSerie=" + numSerie +
                ", capCombustible=" + capCombustible +
                ", costoXKM=" + costoXKM +
                ", capMXPasajeros=" + capMXPasajeros +
                ", velMX=" + velMX +
                ", motor=" + motor +
                ", tarifa=" + tarifa +
                ", reservado=" + reservado +
                '}';
    }
}
