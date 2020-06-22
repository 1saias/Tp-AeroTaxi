package com.company;

import com.company.Aeronaves.*;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlSistema<seleccion> {
    public void inicializarSistema() {
        ///crear archivos
        List<Aviones> iniAVI = new ArrayList<>();
        List<Usuario> iniUser = new ArrayList<>();
        List<Vuelos> iniVue = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema STE AEROTAXIS");
        System.out.println("Por favor,ingresa los siguientes datos a pedir: ");
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Apellido:");
        String apellido = sc.nextLine();
        System.out.println("DNI:");
        int dni = sc.nextInt();
        System.out.println("Edad");
        int edad = sc.nextInt();
        Usuario cliente = new Usuario(nombre, apellido, dni, edad);

        if (validarUsuario(iniUser, cliente) == 1) {
            System.out.println("El usuario existe,el login fue exitoso");
            inicializarMenuPrincSeleccion(iniAVI, iniUser, iniVue, cliente);
        } else {
            System.out.println("El usuario no existe,entonces,su registro fue exitoso");
            iniUser.add(cliente);
            inicializarMenuPrincSeleccion(iniAVI, iniUser, iniVue, cliente);
        }
    }

    public static int validarUsuario(List<Usuario> usuarios, Usuario usuario) {
        int validacion = 0;
        for (Usuario user : usuarios) {
            if (user.equals(usuario) == true) {
                validacion = 1;
            }
        }
        return validacion;
    }

    ///TRAMO 1
    public static void inicializarMenuPrincSeleccion(List<Aviones> iniAvi, List<Usuario> iniUser,
                                                     List<Vuelos> iniVue, Usuario cliente) {
        Scanner sc = new Scanner(System.in);
        int op;
        char resp;
        System.out.println("Seleccione alguna de las siguientes acciones");
        System.out.println("1.Contratar Vuelo");
        System.out.println("2.Cancelar Vuelo");
        System.out.println("3.Informacion");
        System.out.println("4.Terminar Programa");
        op = sc.nextInt();

        do {
            switch (op) {
                case 1:
                    ///Menu CONTRATACION
                    break;
                case 2:
                    //MENU CANCELAR
                    break;
                case 3:
                    //MENU INFORMACION
                    break;
                case 4:
                    //TERMINARTODO
                    break;
            }
            System.out.println("DESEA REALIZAR OTRA OPERACION? S/N");
            resp = sc.next().charAt(0);
        } while (resp != 'N');
    }

    ///TRAMO 2
    ///SELECCION FECHA
    public static int comprobacionfecha(List<Vuelos> vuelos, LocalDateTime seleccion) {
        int i = 0;
        for (Vuelos auxv : vuelos) {
            if (seleccion.compareTo(auxv.getFecha()) == 0) {
                i = 1;
            }
        }
        return i;
    }

    public static LocalDateTime seleccionFecha(List<Vuelos> iniVue) {
        Scanner sc = new Scanner(System.in);
        int mes = 0, dia = 0, hora = 0, minuto = 0;
        char resp;
        System.out.println("-INGRESE A CONTINUACION LOS SIGUIENTES DATOS DE MANERA NUMERICA-");
        System.out.println("EJEMPLO: MES 1 = ENERO,MES 2 = FEBRERO");
        System.out.println("INGRESE MES:");
        mes = sc.nextInt();
        System.out.println("INGRESE DIA(CORRESPONDER FINALES EN CADA MES,SEA 30 O 31 EN CUENTA):");
        dia = sc.nextInt();
        System.out.println("INGRESE HORA(FORMATO 24HS):");
        hora = sc.nextInt();
        System.out.println("INGRESE MINUTO(NO SUPERAR 59):");
        minuto = sc.nextInt();

        LocalDateTime seleccion = LocalDateTime.of(2020, mes, dia, hora, minuto);
        if (comprobacionfecha(iniVue, seleccion) == 1) {
            System.out.println("La fecha ingresada esta disponible \n Desea Confirmar? S/N");
            resp = sc.next().charAt(0);
            if (resp == 'S') {
                System.out.println("Fecha confirmada");
            } else {
                seleccionFecha(iniVue);
            }
        }
        return seleccion;
    }

    //SELECCION AVION
    public static void mostrarAvionesDisponibles(List<Aviones> flota,List<Vuelos> agendados,
                                                 int acompañante,LocalDateTime seleccion) {
        for (Aviones avion : flota) {
            for (Vuelos vuelo : agendados) {
                if (vuelo.getFecha().compareTo(seleccion) == 0) {
                    if (flota.equals(vuelo.getAeronave()) == false) {
                        if(avion.getCapMXPasajeros() >= acompañante){
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
                        }else {
                            System.out.println("No hay ninguna aeronave disponible con dicha capacidad," +
                                    "ingrese otra fecha o elija otro avion");
                        }
                    }
                }
            }
        }
        System.out.println("Si no logro ver ninguna aeronave para su seleccion,ingrese otra fecha,por favor");
    }

    public static Aviones seleccionAvion(List<Aviones> iniAvi,List<Vuelos> iniVue,
                                         int acompañante,LocalDateTime seleccionado) {
        Scanner sc = new Scanner(System.in);
        Aviones seleccion = new Aviones();
        mostrarAvionesDisponibles(iniAvi,iniVue,acompañante,seleccionado);
        System.out.println("Ingrese el numero de serie del avion que desee seleccionar");
        int numSer = sc.nextInt();
        for (Aviones aux : iniAvi) {
            if (aux.getNumSerie() == numSer) {
                    seleccion = aux;
            }
        }
        return seleccion;
    }


    public static void menuContratacion(List<Aviones> iniAvi, List<Usuario> iniUser,
                                        List<Vuelos> iniVue, Usuario cliente) {
        Scanner sc = new Scanner(System.in);
        char resp;
        int acompañantes;
        System.out.println("-Bienvido al menu de contratacion " + cliente.getNombre() + "-");

        LocalDateTime selFecha = seleccionFecha(iniVue);
        System.out.println("Ingrese el origen de su vuelo");

        ///MOSTRAR ORIGEN,DESTINO SIN LA CIUDAD SELECCIONADA Y LUEGO AGREGAR EN UN STRING CADA UNO;

        System.out.println("Ingrese cantidad de acompañantes");
        acompañantes = sc.nextInt();
        Aviones selAvion = seleccionAvion(iniAvi,iniVue,acompañantes,selFecha);
        /*if (aux instanceof Bronze) {
            Bronze selAvion = (Bronze) aux;
        } else {
        if (aux instanceof Silver) {
                Silver selAvion = (Silver) aux;
        } else {
        if (aux instanceof Gold) {
                    Gold selAvion = (Gold) aux;
        }
            }
        }*/

        Vuelos nuevo = new Vuelos();
        nuevo = new Vuelos(selFecha,acompañantes,cliente,selAvion,nuevo.ContarKm(nuevo.getOrigen(),nuevo.getDestino()),
                origen elegido,Destino elegido);
        for(Vuelos aux: iniVue){
            if(aux.equals(nuevo)==true){
                System.out.println("hay un vuelo programado,elija otro dia");
                seleccionFecha(iniVue);
            }
            System.out.println("Su proceso fue satifactorio,desea confirmar S/N");
            resp = sc.next().charAt(0);
            if(resp == 'S'){
                iniVue.add(nuevo);
            }
        }


    }

}