package com.company.Aeronaves;

public class Silver extends Avion {
    public Silver(String nombre, int numSerie, float capCombustible,
                  float costoXKM, int capMXPasajeros, float velMX, Motor motor) {
        super(nombre, numSerie, capCombustible, costoXKM, capMXPasajeros, velMX, motor,4000);
    }

    @Override
    public String toString() {
        return "Avion: " +this.getClass().getSimpleName()+
               "Numero de Serie=" + this.numSerie +
               "Capacidad de combustible: " + this.capCombustible +
               "Costo por Kilometro: " + this.costoXKM +
               "Capacidad maxima de Pasajeros: " + this.capMXPasajeros +
               "Velocidad Maxima: " + velMX +
               "Motor tipo: " + this.motor.name();
    }
}

