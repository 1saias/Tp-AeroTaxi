package com.company;

import com.company.Aeronaves.*;
import com.company.Reserva.Vuelo;
import com.company.Sistema.ControlSistema;
import com.company.User.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        /*Usuario us1 = new Usuario("Carlos","Montana",48497136,58);
        Usuario us2 = new Usuario("Tomas","Vermaelen",29781265,28);
        Usuario us3 = new Usuario("Isable","Alfonsino",78412364,15);

        Bronze latita = new Bronze("latita",8921,66f,58f,90,600,Motor.AHelice);
        Silver bral = new Silver("bral",2254,80f,90f,120,700,Motor.AReaccion);
        Gold villancio = new Gold("villancio",6666,160f,80f,130,800,Motor.APropulsion);

            LocalDate fecha1 = LocalDate.of(2020,7,22);
        LocalDateTime fecha2 = LocalDate.of(2020,9,17);
        LocalDatet fecha3 = LocalDate.of(2020,11,6);
        LocalDate fecha4 = LocalDate.of(2020,8,17);

        Vuelo seriales1 = new Vuelo(fecha1,30,us1,latita, Vuelo.Origen.BsAs, Vuelo.Destino.Santiago);
        Vuelo seriales2 = new Vuelo(fecha2,80,us3,villancio, Vuelo.Origen.Cordoba, Vuelo.Destino.Montevideo);
        Vuelo seriales3 = new Vuelo(fecha3,90,us2,bral, Vuelo.Origen.Montevideo, Vuelo.Destino.Santiago);
        Vuelo seriales4 = new Vuelo(fecha4,146,us3,villancio, Vuelo.Origen.BsAs, Vuelo.Destino.Santiago);



        List<Vuelo> iniVue = new LinkedList<>();
        iniVue.add(seriales1);  iniVue.add(seriales2);  iniVue.add(seriales3); iniVue.add(seriales4);

        List<Usuario> iniUser = new ArrayList<>();
        iniUser.add(us1);  iniUser.add(us2);  iniUser.add(us3);

        List<Avion> iniAvi = new ArrayList<>();
        iniAvi.add(latita);  iniAvi.add(bral);  iniAvi.add(villancio);

        ControlSistema.menuInicio(iniAvi,iniUser,iniVue);







       /* Usuario Pepe = new Usuario("Pepito","Fernandez",15423891,50);
        Usuario Pipo = new Usuario("Pedro","Lopez",62987634,58);



       Bronze stratoCosta = new Bronze("avionxd",150,30,500f,30,50f,Motor.APropulsion);
       System.out.println("Classe:"+stratoCosta.toString());

        Vuelo directorio1 = new Vuelo(LocalDateTime.of(2020,6,22,23,15),10,230,Pepe,Piderosta, Vuelo.Origen.BsAs, Vuelo.Destino.Montevideo);
        Vuelo directorio2 = new Vuelo(LocalDateTime.of(2020,6,21,20,15),10,230,Pipo,stratoCosta, Vuelo.Origen.BsAs, Vuelo.Destino.Cordoba);
        List<Vuelo> flota = new LinkedList<>();
        flota.add(directorio1);
        flota.add(directorio2);*/



        /*or(Avion av : iniAvi){
            System.out.println(av.toString());
        }















        for(Vuelo vl : iniVue){
            System.out.println(vl.toString());
        }*/


        //*for(Avion flotita : Flota){*/

        /*for(Avion flotita : Flota){
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

        /*LocalDateTime seleccion = LocalDateTime.of(2020,7,22,14,10);//LocalDateTime.of(2020,10,15,20,28);
        int i=0;


        if(fecha1.getMonth().compareTo(seleccion.getMonth())==0){
            i=1;
        }
        System.out.println(i);

        if(fecha1.getDayOfMonth()==seleccion.getDayOfMonth()){
            i = 1;
        }
        System.out.println(i);

        if(latita.getCapMXPasajeros()>= 80+1){
            i=1;
        }
        System.out.println(i);*/

        /*int acompañante = 80;
        for (Avion avion : iniAvi) {
            for (Vuelo vuelo : iniVue) {
                if (vuelo.getFecha().getMonth().compareTo(seleccion.getMonth()) == 0) {
                    System.out.println("Si paso");
                    if (vuelo.getFecha().getDayOfMonth() == seleccion.getDayOfMonth()) {
                        System.out.println("Si paso");
                        if (vuelo.getAeronave().getNombre().equalsIgnoreCase(avion.getNombre())==false) {
                            System.out.println("Si paso");
                            if (avion.getCapMXPasajeros() >= acompañante + 1) {
                                if (avion instanceof Bronze) {
                                    System.out.println(avion.toString());
                                } else {
                                    if (avion instanceof Silver) {
                                        System.out.println(avion.toString());
                                    } else {
                                        if (avion instanceof Gold) {
                                            System.out.println(avion.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }*/






    }
}
