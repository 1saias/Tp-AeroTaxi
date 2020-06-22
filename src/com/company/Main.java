package com.company;

import com.company.Aeronaves.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {


        Usuario Pepe = new Usuario("Pepito","Fernandez",15423891,50);
        Usuario Pipo = new Usuario("Pedro","Lopez",62987634,58);



       Bronze stratoCosta = new Bronze("avionxd",150,30,500f,30,50f,Motor.APropulsion);
       System.out.println("Classe:"+stratoCosta.toString());

        /*Vuelos directorio1 = new Vuelos(LocalDateTime.of(2020,6,22,23,15),10,230,Pepe,Piderosta, Vuelos.Origen.BsAs, Vuelos.Destino.Montevideo);
        Vuelos directorio2 = new Vuelos(LocalDateTime.of(2020,6,21,20,15),10,230,Pipo,stratoCosta, Vuelos.Origen.BsAs, Vuelos.Destino.Cordoba);
        List<Vuelos> flota = new LinkedList<>();
        flota.add(directorio1);
        flota.add(directorio2);*/


















/*


        directorio1.CancelarVuelo(directorio1.getFecha(),directorio1.getAeronave());

        System.out.println(directorio1.getFecha());
        System.out.println(LocalDateTime.now());
        System.out.println();

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

        *//*for(Aviones flotita : Flota){*/

        /*for(Aviones flotita : Flota){
            if(flotita instanceof Bronze){
                System.out.println(flotita.toString());
            }else {
                if(flotita instanceof Silver){
                    System.out.println(flotita.toString());
                }
            }
        }
        LocalDateTime seleccioN = LocalDateTime.of(2020,9,15,15,30);
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
