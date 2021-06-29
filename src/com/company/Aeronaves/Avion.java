package com.company.Aeronaves;

public class Avion {
    protected int numSerie;
    protected float capCombustible;
    protected float costoXKM;
    protected  int capMXPasajeros;
    protected float velMX;          //En km/h
    protected Motor motor;
    protected float tarifaUnica;

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

    public void setVelMX(float velMX) {
        this.velMX = velMX;
    }
    public float getVelMX() {
        return this.velMX;
    }

    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public float getTarifaUnica() {
        return this.tarifaUnica;
    }
    public void setTarifaUnica(float tarifaUnica) {
        this.tarifaUnica = tarifaUnica;
    }


    public Avion(String nombre, int numSerie, float capCombustible, float costoXKM, int capMXPasajeros,
                 float velMX, Motor motor,float tarifaUnica){
        this.numSerie = numSerie;
        this.capCombustible = capCombustible;
        this.costoXKM = costoXKM;
        this.capMXPasajeros = capMXPasajeros;
        this.velMX = velMX;
        this.motor = motor;
        this.tarifaUnica = tarifaUnica;
    }
}
