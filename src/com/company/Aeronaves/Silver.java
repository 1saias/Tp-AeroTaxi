package com.company.Aeronaves;

import com.company.Menu;
import com.company.Motor;

public class Silver extends Aviones  {
    private String Platillo;

    public Silver(float capCombustible, float costoXKM, int capMXPasajeros, double velMX, Motor motor, String platillo) {
        super(capCombustible, costoXKM, capMXPasajeros, velMX, motor,4000);
        Platillo = platillo;
    }

    public String getPlatillo() {
        return Platillo;
    }

    @Override
    public String toString() {
        return "Silver: "+super.toString()+"Platillo: "+getPlatillo();
    }


}
