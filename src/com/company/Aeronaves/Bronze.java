package com.company.Aeronaves;

import com.company.Aeronaves.Aviones;
import com.company.Motor;

public class Bronze extends Aviones {
    public Bronze(float capCombustible, float costoXKM, int capMXPasajeros, double velMX, Motor motor) {
        super(capCombustible, costoXKM, capMXPasajeros, velMX, motor);
    }

    @Override
    public String toString() {
        return "Bronze: "+super.toString();
    }
}
