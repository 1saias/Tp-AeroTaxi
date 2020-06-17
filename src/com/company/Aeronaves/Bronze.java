package com.company.Aeronaves;

import com.company.Aeronaves.Aviones;

public class Bronze extends Aviones {
    public Bronze(float capCombustible, float costoXKM, int capMXPasajeros, double velMX, String motor) {
        super(capCombustible, costoXKM, capMXPasajeros, velMX, motor);
    }

    @Override
    public String toString() {
        return "Bronze: "+super.toString();
    }
}
