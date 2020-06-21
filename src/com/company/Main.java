package com.company;

import com.company.Aeronaves.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario Pepe = new Usuario("Pepito","Fernandez",15423891,50);
        Bronze stratoCosta = new Bronze(55f,150f,30,500f,Motor.AHelice);
        Silver Piderosta = new Silver(79F,280F,80,600F,Motor.AReaccion,Menu.eleccion9);
        Vuelos volar = new Vuelos(LocalDateTime.now(),2,Pepe,Piderosta, Vuelos.Destino.Montevideo, Vuelos.Origen.Cordoba);
        List<Aviones> Flota = new ArrayList<>();
        Flota.add(stratoCosta);
        Flota.add(Piderosta);
        System.out.println(volar);

        for(Aviones flotita : Flota){
            if(flotita instanceof Bronze){
                System.out.println(flotita.toString());
            }else {
                if(flotita instanceof Silver){
                    System.out.println(flotita.toString());
                }
            }
        }
        /*LocalDateTime seleccioN = LocalDateTime.of(2020,9,15,15,30);
        LocalDateTime estaba = LocalDateTime.of(2020,6,20,12,00);
        LocalDateTime seria = LocalDateTime.of(2020,9,15,15,30);
        System.out.println(seleccioN);
        System.out.println(estaba);
        int i=0;
        if(seleccioN.compareTo(seria)==0){
                    i=1;
        }
        System.out.println(i);*/

    }

    }
