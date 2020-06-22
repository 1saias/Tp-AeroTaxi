package com.company;

import com.company.Aeronaves.*;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlSistema {

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

        do {
            System.out.println("Seleccione alguna de las siguientes acciones");
            System.out.println("1.Contratar Vuelo");
            System.out.println("2.Cancelar Vuelo");
            System.out.println("3.Informacion");
            System.out.println("4.Terminar Programa");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    iniVue=menuContratacion(iniAvi, iniUser, iniVue, cliente);
                    break;
                case 2:
                    iniVue = cancelarVuelo(iniVue,cliente);
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
        } else {
            System.out.println("Hay un vuelo programado para esa fecha,por favor ingrese otra");
            seleccionFecha(iniVue);
        }
        return seleccion;
    }

    //SELECCION AVION
    public static void mostrarAvionesDisponibles(List<Aviones> iniAvi, List<Vuelos> inivue,
                                                 int acompañante, LocalDateTime seleccion) {
        for (Aviones avion : iniAvi) {
            for (Vuelos vuelo : inivue) {
                if (vuelo.getFecha().getMonth().compareTo(seleccion.getMonth()) == 0) {
                    if (vuelo.getFecha().getDayOfMonth() == seleccion.getDayOfMonth()) {
                        if (iniAvi.equals(vuelo.getAeronave()) == false) {
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
        }
    }

    public static Aviones seleccionAvion(List<Aviones> iniAvi, List<Vuelos> iniVue, List<Usuario> iniUser, int acompañante, LocalDateTime seleccionado, Usuario cliente) {
        Scanner sc = new Scanner(System.in);
        Aviones seleccion = new Aviones();
        mostrarAvionesDisponibles(iniAvi, iniVue, acompañante, seleccionado);
        System.out.println("Ingrese el numero de serie del avion que desee seleccionar  \n" +
                "En caso de no ver ningun avion(no se pudo encontrar uno con sus requerimientos) " +
                "o de no estar satisfecho con lo mostrado" +
                "Ingrese 0 para volver a la seleccion de fechas");
        int numSer = sc.nextInt();
        if (numSer != 0) {
            for (Aviones aux : iniAvi) {
                if (aux.getNumSerie() == numSer) {
                    seleccion = aux;
                }
            }
        } else {
            menuContratacion(iniAvi, iniUser, iniVue, cliente);
        }
        return seleccion;
    }

    ///MENU DE CONTRATACION Y CREACION DEL VUELO
    public static List<Vuelos> menuContratacion(List<Aviones> iniAvi, List<Usuario> iniUser, List<Vuelos> iniVue, Usuario cliente) {
        Scanner sc = new Scanner(System.in);
        char resp;
        int acompañantes;
        Vuelos nuevo = new Vuelos();
        System.out.println("-Bienvido al menu de contratacion " + cliente.getNombre() + "-");

        LocalDateTime selFecha = seleccionFecha(iniVue);

        System.out.println("Ingrese el origen de su vuelo  \n");

            System.out.println("1- Buenos Aires \n");

            System.out.println("2- Cordoba\n");

            System.out.println("3- Montevideo\n");

            int origen=sc.nextInt();

            switch (origen){
                case 1:
                    nuevo.setOrigen(Vuelos.Origen.BsAs);

                    System.out.println("Ingrese el destino de su vuelo \n");

                    System.out.println("1-Cordoba \n");

                    System.out.println("2-Montevideo \n");

                    System.out.println("3-Santiago\n");


                    int destinoBSas = sc.nextInt();
                    if (destinoBSas == 1){
                        nuevo.setDestino(Vuelos.Destino.Cordoba);
                    }
                    if (destinoBSas == 2){
                        nuevo.setDestino(Vuelos.Destino.Montevideo);
                    }
                    if (destinoBSas == 3){
                        nuevo.setDestino(Vuelos.Destino.Santiago);

                    }
                    break;
                    case 2:
                    nuevo.setOrigen(Vuelos.Origen.Cordoba);

                    System.out.println("Ingrese el destino de su vuelo \n");

                    System.out.println("1- Montevideo\n");

                    System.out.println("2- Santiago\n");

                    int destinoCordoba = sc.nextInt();

                    if (destinoCordoba == 1){

                        nuevo.setDestino(Vuelos.Destino.Montevideo);

                    }else if(destinoCordoba == 2){

                        nuevo.setDestino(Vuelos.Destino.Santiago);
                    }
                    break;

                    case 3:
                        nuevo.setOrigen(Vuelos.Origen.Montevideo);

                        System.out.println("Ingrese el destino de su vuelo\n");

                        System.out.println("1-Santiago\n");

                        int destinoMontevideo = sc.nextInt();

                        if (destinoMontevideo == 1){

                            nuevo.setDestino(Vuelos.Destino.Santiago);
                        }

                        break;

            }
        System.out.println("Ingrese cantidad de acompañantes");

        acompañantes = sc.nextInt();
        Aviones selAvion = seleccionAvion(iniAvi, iniVue, iniUser, acompañantes, selFecha, cliente);
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


        for (Vuelos aux : iniVue) {
            if (aux.equals(nuevo) == true) {
                System.out.println("Hay un vuelo programado,elija otro dia");
                iniVue = menuContratacion(iniAvi, iniUser, iniVue, cliente);
            }
            System.out.println(nuevo.toString());
            System.out.println("Su proceso fue satifactorio,desea confirmar S/N");
            resp = sc.next().charAt(0);
            if (resp == 'S') {
                iniVue.add(nuevo);
            }
        }

    return iniVue;
    }
///MENU DE CANCELACION
    public static List<Vuelos> borrarVuelo(List<Vuelos> iniVue, Usuario cliente, LocalDateTime fecha) {
        LocalDateTime fechaEnElMomento = LocalDateTime.now();
        boolean dictador = fecha.isAfter(fechaEnElMomento);
        int i = 0;int funka=0;
        if (dictador == true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Desea realmente cancelar el vuelo? \n ");
            System.out.println("Presion 1 para continuar");
            System.out.println("Presion 0 para cancelar ");
            int confirmacion = sc.nextInt();
            if (confirmacion == 1) {
                for (Vuelos vl : iniVue) {
                    if (vl.getUsuario().equals(cliente)==true) {
                        if (vl.getFecha().compareTo(fecha) == 0) {
                            iniVue.remove(i);
                            funka =1;
                        }
                    }
                    i++;
                }
            }
        }
        System.out.println("Vuelo eliminado Satisfactoriamente");
        return iniVue;
    }

    public static List<Vuelos> cancelarVuelo(List<Vuelos> iniVue,Usuario cliente){
        Scanner sc = new Scanner(System.in);
        int mes = 0, dia = 0, hora = 0, minuto = 0;
        char resp;
        System.out.println("-MENU DE CANCELACION DE VUELO");
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
        LocalDateTime borrar = LocalDateTime.of(2020,mes,dia,hora,minuto);
        iniVue = borrarVuelo(iniVue,cliente,borrar);
        System.out.println("Desea remover otro vuelo? S/N");
            int op = sc.next().charAt(0);
            if(op =='s'){
                iniVue=cancelarVuelo(iniVue,cliente);
            }
        return iniVue;
    }

///MENU DE INFORMACION
    public static void menuInformacion(List<Vuelos> inivue,List<Usuario> iniUser){
        Scanner sc = new Scanner(System.in);int op= 0,mes = 0, dia = 0, hora = 0, minuto = 0;
        System.out.println("-BIENVENIDO AL MENU DE INFORMACION-\n " +
                            "Seleccione una de las siguientes opciones:\n " +
                            "1.Mostrar vuelos segun una fecha\n" +
                            "2.Mostrar Clientes");
                op= sc.nextInt();
                switch (op){
                    case 1:
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
                        LocalDateTime mostrar = LocalDateTime.of(2020,mes,dia,hora,minuto);
                        mostrarVLSegunFecha(inivue,mostrar);
                        break;
                    case 2:
                        mostrarClientes(iniUser,inivue);
                        break;
                }
    }

    public static void mostrarVLSegunFecha(List<Vuelos> iniVue,LocalDateTime fecha){
        for (Vuelos vl : iniVue){
            if(vl.getFecha().compareTo(fecha)==0){
                System.out.println(vl.toString());
            }
        }
    }

    public static void mostrarClientes(List<Usuario> iniUser,List<Vuelos> iniVue) {
        System.out.println("-CLIENTES-");
        for (Usuario us : iniUser) {
            int total = 0,bronze = 0, silver = 0, gold = 0;
            System.out.println("===================================================================");
            us.toString();
            for (Vuelos vl : iniVue) {
                if (vl.getUsuario().getDni() == us.getDni()) {
                    total += vl.getImporte();
                if (vl.getAeronave() instanceof Bronze) {
                    bronze++;
                } else {
                if (vl.getAeronave() instanceof Silver) {
                    silver++;
                } else {
                if (vl.getAeronave() instanceof Gold) {
                    gold++;
                            }
                        }
                    }
                }
            }
            mostrarMayor(bronze, silver, gold);
            System.out.println("El importe total de todos los vuelos es: "+total);
        }
    }

    public static void mostrarMayor(int bronze,int silver,int gold){
        if(bronze > silver && bronze > gold){
            System.out.println("Bronze es la mejor categoria");
        }else{
        if(bronze == silver && bronze > gold){
            System.out.println("Bronze y Silver son las mejores categorias");
        }else {
        if(bronze > silver && bronze == gold){
            System.out.println("Bronze y Gold son las mejores categorias");
        }else {
        if(bronze < silver && silver > gold){
            System.out.println("Silver es la mejor categoria");
        }else{
        if(bronze < silver && silver == gold) {
            System.out.println("Silver y Gold son las mejores categorias");
        }else{
        if(bronze < gold && silver < gold){
            System.out.println("Gold es la mejor categoria");
        }else{
        if(bronze == gold && silver == gold){
            System.out.println("Las tres categorias son las mejores e iguales");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
