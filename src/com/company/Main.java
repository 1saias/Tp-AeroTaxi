package com.company;

import com.company.Aeronaves.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        Usuario us1 = new Usuario("Carlos","Montana",48497136,58);
        Usuario us2 = new Usuario("Tomas","Vermaelen",29781265,28);
        Usuario us3 = new Usuario("Isable","Alfonsino",78412364,15);

        Bronze latita = new Bronze("latita",8921,66f,58f,90,600,Motor.AHelice);
        Silver bral = new Silver("bral",2254,80f,90f,120,700,Motor.AReaccion,Menu.eleccion6);
        Gold villancio = new Gold("villancio",6666,160f,80f,130,800,Motor.APropulsion,Menu.eleccion4,"Posee wi fi");

            LocalDateTime fecha1 = LocalDateTime.of(2020,7,22,14,10);
            LocalDateTime fecha2 = LocalDateTime.of(2020,9,17,5,30);
            LocalDateTime fecha3 = LocalDateTime.of(2020,11,6,8,45);
            LocalDateTime fecha4 = LocalDateTime.of(2020,8,17,18,15);

        Vuelos seriales1 = new Vuelos(fecha1,30,us1,latita, Vuelos.Origen.BsAs, Vuelos.Destino.Santiago);
        Vuelos seriales2 = new Vuelos(fecha2,80,us3,villancio, Vuelos.Origen.Cordoba, Vuelos.Destino.Montevideo);
        Vuelos seriales3 = new Vuelos(fecha3,90,us2,bral, Vuelos.Origen.Montevideo, Vuelos.Destino.Santiago);
        Vuelos seriales4 = new Vuelos(fecha4,146,us3,villancio, Vuelos.Origen.BsAs, Vuelos.Destino.Santiago);

        List<Vuelos> iniVue = new LinkedList<>();
        iniVue.add(seriales1);  iniVue.add(seriales2);  iniVue.add(seriales3); iniVue.add(seriales4);

        List<Usuario> iniUser = new ArrayList<>();
        iniUser.add(us1);  iniUser.add(us2);  iniUser.add(us3);

        List<Aviones> iniAvi = new ArrayList<>();
        iniAvi.add(latita);  iniAvi.add(bral);  iniAvi.add(villancio);

        ControlSistema.inicializarSistema(iniAvi,iniUser,iniVue);







       /* Usuario Pepe = new Usuario("Pepito","Fernandez",15423891,50);
        Usuario Pipo = new Usuario("Pedro","Lopez",62987634,58);



       Bronze stratoCosta = new Bronze("avionxd",150,30,500f,30,50f,Motor.APropulsion);
       System.out.println("Classe:"+stratoCosta.toString());

        Vuelos directorio1 = new Vuelos(LocalDateTime.of(2020,6,22,23,15),10,230,Pepe,Piderosta, Vuelos.Origen.BsAs, Vuelos.Destino.Montevideo);
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
