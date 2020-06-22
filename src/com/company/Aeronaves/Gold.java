package com.company.Aeronaves;

import com.company.Menu;
import com.company.Motor;

public class Gold extends Aviones{
    private String platillo;
    private String wifi;

    public Gold(String nombre, int numSerie, float capCombustible, float costoXKM, int capMXPasajeros, double velMX, Motor motor, int tarifa) {
        super(nombre, numSerie, capCombustible, costoXKM, capMXPasajeros, velMX, motor,6000);
        this.platillo = platillo;
        this.wifi = wifi;
    }


    public String getPlatillo() {
        return platillo;
    }

    public String getWifi() {
        return wifi;
    }

    @Override
    public String toString() {
        return "Gold: "+super.toString()+"Platillo: "+getPlatillo()+", Wifi: "+getWifi();
    }
}
