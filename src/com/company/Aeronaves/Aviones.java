package com.company.Aeronaves;

public abstract class Aviones {
    private float capCombustible;
    private float costoXKM;
    private int capMXPasajeros;
    private double velMX;          //En km/h
    private String motor;

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

    public void setMotor(String motor) {
        motor = motor;
    }
    public String getMotor() {
        return this.motor;
    }

    public Aviones(float capCombustible,float costoXKM,int capMXPasajeros,double velMX,String motor){
        this.capCombustible = capCombustible;
        this.costoXKM = costoXKM;
        this.capMXPasajeros = capMXPasajeros;
        this.velMX = velMX;
        this.motor = motor;
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
