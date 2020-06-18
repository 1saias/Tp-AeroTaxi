package com.company.Aeronaves;

import com.company.Aeronaves.Aviones;
import com.company.SerCatering;

public class Silver extends Aviones implements SerCatering {
    private String Platillo;

    public Silver(float capCombustible, float costoXKM, int capMXPasajeros, double velMX, String motor) {
        super(capCombustible, costoXKM, capMXPasajeros, velMX, motor);
    }

    @Override
    public String toString() {
        return "Silver: "+super.toString();
    }

    @Override
    public void menu(String eleccion){
        this.Platillo = eleccion;
    }

}
