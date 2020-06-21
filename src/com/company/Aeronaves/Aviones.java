package com.company.Aeronaves;

import com.company.Motor;

public abstract class Aviones {
    private float capCombustible;
    private float costoXKM;
    private int capMXPasajeros;
    private double velMX;          //En km/h
    private Motor motor;
    private int tarifa;
    private int reservado =0;

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

    public Aviones(float capCombustible, float costoXKM, int capMXPasajeros, double velMX, Motor motor,int tarifa){
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
                "capCombustible=" + this.capCombustible +
                ", costoXKM=" + this.costoXKM +
                ", capMXPasajeros=" + this.capMXPasajeros +
                ", velMX=" + this.velMX +
                ", motor='" + this.motor + '\'' +
                '}';
    }

}
