package com.company;

import com.company.Aeronaves.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario Pepe = new Usuario("Pepito","Fernandez",15423891,50);
        Usuario Pipo = new Usuario("Pedro","Lopez",62987634,58);
        Bronze stratoCosta = new Bronze(55f,150f,30,500f,Motor.AHelice);
        Silver Piderosta = new Silver(79F,280F,80,600F,Motor.AReaccion,Menu.eleccion9);
<<<<<<< HEAD
        Vuelos directorio1 = new Vuelos(LocalDateTime.of(2020,6,22,23,15),10,230,Pepe,Piderosta, Vuelos.Ciudades.BsAs, Vuelos.Destinos.Cordoba);
        Vuelos directorio2 = new Vuelos(LocalDateTime.of(2020,6,21,20,15),10,230,Pepe,stratoCosta, Vuelos.Ciudades.BsAs, Vuelos.Destinos.Cordoba);
        List<Aviones> flota = new ArrayList<>();
        flota.add(stratoCosta);
        flota.add(Piderosta);

        for(Aviones avion : flota){
            if(avion.getReservado() == 1){
                if(avion instanceof Bronze){
                    System.out.println(avion.toString());
                }else{
                    if(avion instanceof Silver){
                        System.out.println(avion.toString());
                    }else{
                        if(avion instanceof Gold){
                            System.out.println(avion.toString());
                        }
                    }
                }
            }
        }














=======
        Vuelos directorio1 = new Vuelos(LocalDateTime.of(2020,21,6,20,15),10,230,Pepe,Piderosta, Vuelos.Ciudades.BsAs, Vuelos.Destinos.Cordoba);
        Vuelos directorio2 = new Vuelos(LocalDateTime.of(2020,27,7,23,15),10,230,Pepe,stratoCosta, Vuelos.Ciudades.BsAs, Vuelos.Destinos.Cordoba);
        List<Aviones> Flota = new ArrayList<>();
        Flota.add(stratoCosta);
        Flota.add(Piderosta);
        /// Dejame pushear por favor
>>>>>>> b4e266363af465c162b77c5341b1b57711692f8b
        /*for(Aviones flotita : Flota){
            if(flotita instanceof Bronze){
                System.out.println(flotita.toString());
            }else {
                if(flotita instanceof Silver){
                    System.out.println(flotita.toString());
                }
            }
        }*/
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
