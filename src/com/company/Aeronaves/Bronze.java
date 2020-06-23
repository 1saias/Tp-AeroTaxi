package com.company.Aeronaves;

import com.company.Aeronaves.Aviones;
import com.company.Motor;

public class Bronze extends Aviones {


    public Bronze(String nombre, int numSerie, float capCombustible, float costoXKM,
                  int capMXPasajeros, double velMX, Motor motor) {
        super(nombre, numSerie, capCombustible, costoXKM, capMXPasajeros, velMX, motor, 3000);
    }

    @Override
    public String toString() {
        return "Bronze: "+super.toString();
    }
}
