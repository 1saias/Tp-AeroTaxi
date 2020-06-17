package com.company;

import com.company.Aeronaves.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bronze stratoCosta = new Bronze(55f,150f,30,500f,Motor.mAh);
        Silver Piderosta = new Silver(79F,280F,80,600F,Motor.mAp);
        List<Aviones> Flota = new ArrayList<>();
        Flota.add(stratoCosta);
        Flota.add(Piderosta);

        /*for(Aviones flotita : Flota){
            if(flotita instanceof Bronze){
                System.out.println(flotita.toString());
            }else {
                if(flotita instanceof Silver){
                    System.out.println(flotita.toString());
                }
            }
        }*/

    }

    }
