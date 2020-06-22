package com.company.Aeronaves;

import com.company.Menu;
import com.company.Motor;

public class Silver extends Aviones  {
    private String platillo;

    public Silver(String nombre, int numSerie, float capCombustible, float costoXKM, int capMXPasajeros, double velMX, Motor motor,String platillo) {
        super(nombre, numSerie, capCombustible, costoXKM, capMXPasajeros, velMX, motor, 4000);
        this.platillo = platillo;
    }


    public String getPlatillo() {
        return platillo;
    }

    @Override
    public String toString() {
        return "Silver: "+super.toString()+"Platillo: "+getPlatillo();
    }

}
