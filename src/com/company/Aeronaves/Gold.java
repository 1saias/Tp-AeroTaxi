package com.company.Aeronaves;

public class Gold extends Aviones{
    private String Platilo;

    public Gold(float capCombustible, float costoXKM, int capMXPasajeros, double velMX, String motor) {
        super(capCombustible, costoXKM, capMXPasajeros, velMX, motor);
    }

    @Override
    public void menu(String eleccion){
        this.Platilo = eleccion;
    }
    @Override
    public String toString() {
        return "Gold: "+super.toString();
    }
}
