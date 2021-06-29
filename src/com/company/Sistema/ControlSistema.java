package com.company.Sistema;

import com.company.Aeronaves.Avion;
import com.company.Aeronaves.Gold;
import com.company.Aeronaves.Silver;
import com.company.GastosExtras.GastoExtra;
import com.company.GastosExtras.Platillos;
import com.company.Reserva.*;
import com.company.User.Usuario;

import java.io.IOException;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ControlSistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private ArrayList<Vuelo> vuelos;
    private ArrayList<Avion> aviones;

    public ControlSistema() {
        try {
            this.usuarios = Archivos.leerUsuarios();
            this.reservas = Archivos.leerReservas();
            this.vuelos = Archivos.leerVuelos();
            this.aviones = Archivos.leerAviones();
        } catch (IOException e) {
            System.out.println("No ha podido inicializarce el sistema,contacte con un administrador");
        }
    }

    public void menuInicio() {
        Scanner sc = new Scanner(System.in);
        Usuario usuario;
        System.out.println("Bienvenido al sistema Mc Carran AEROTAXIS");
        System.out.println("1) Ingresar \n 2) Registrarse \n 3)Salir");
        switch (sc.nextInt()) {
            case 1:
                usuario = menuLoggin();
                if (usuario != null) {
                    menuAdministracion(usuario);
                } else {
                    System.err.println("Error de loggin, intente nuevamente");
                }

                break;

            case 2:
                usuario = menuRegistro();
                this.usuarios.add(usuario);
                try {
                    Archivos.agregarUsuario(this.usuarios);
                } catch (IOException e) {
                    System.err.println("No se ha podido guardar");
                }
                menuAdministracion(usuario);
                break;

            case 3:
                break;

            default:
                System.out.println("Las opciones son de 1 a 3");
        }
    }

    ///----USUARIO----///
    public Usuario menuRegistro() {
        System.out.println("MENU REGISTRO PASAJERO");
        Usuario nuevoUsuario = null;
        int salir = 1;
        Scanner scannerPasajero = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = scannerPasajero.nextLine();
        System.out.println("Apellido: ");
        String apellido = scannerPasajero.nextLine();
        System.out.println("Apellido: ");
        int edad = scannerPasajero.nextInt();
        String dni;
        do {
            boolean control = false;
            do {
                System.out.println("DNI: ");
                dni = scannerPasajero.nextLine();
                control = true;
                if (controlDNIEsUnINT(dni) == false || dni.length() != 8) {
                    System.err.println("Ingreso un valor no valido");
                    control = false;
                }
            } while (control == false);
        } while (controlDNIEsUnINT(dni) == false);

        if (!(validarUsuario(dni))) {
            nuevoUsuario = new Usuario(nombre, apellido, dni, edad);
        } else {
            System.err.println("Ya hay un usuario con dicho DNI");
        }
        return nuevoUsuario;
    }

    public Usuario menuLoggin() {
        Usuario usuario = null;
        int control = 0;
        boolean revision = false;
        String dni;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.println("Ingrese su dni: ");
                    dni = scanner.nextLine();
                    revision = true;
                    if (controlDNIEsUnINT(dni) == false || dni.length() != 8) {
                        if (validarUsuario(dni)) {
                            revision = false;
                        }
                    }
                    System.err.println("Ingreso un dni no valido");
                    control++;
                } while (revision == false);
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
        } while (control != 3);
        return usuario;
    }

    public void menuAdministracion(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU ADMINISTRACION " + usuario.getNombre().toLowerCase() + usuario.getApellido().toUpperCase());
        System.out.println("Ingrese a que menu desea ingresar: ");
        System.out.println("1) Menu Perfil \n 2) Menu Reserva");
        switch (sc.nextInt()) {
            case 1:
                menuPerfil(usuario);
                break;
            case 2:
                MenuReserva(usuario);
                break;
            default:
                System.out.println("OPCIONES 1 Y 2 UNICAMENTE");
        }


    }

    public void menuPerfil(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU PERFIL --" + usuario.getNombre().toLowerCase() + usuario.getApellido().toUpperCase());
        System.out.println("Ingrese a que menu desea ingresar: ");
        System.out.println("1) Ver Perfil \n 2) Modificar Perfil \n 3)Salir");
        switch (sc.nextInt()) {
            case 1:
                System.out.println(usuario.toString());
                break;
            case 2:
                menuModPerfil(usuario);
                try {
                    Archivos.agregarUsuario(this.usuarios);
                    Archivos.agregarReservas(this.reservas);
                } catch (IOException e) {
                    System.err.println("Fallo el guardado de datos");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Ingreso una opcion invalida,solo del 1 a 3");
        }
    }

    public void menuModPerfil(Usuario usuario) {
        boolean salir = false;
        do {
            try {
                System.out.println("Perfil de " + usuario.getNombre() + " " + usuario.getApellido() +
                        "\nQue desea modificar?\n\t1_Nombre\n\t2_Apellido\n\t3_DNI\n\t4_Contraseña\n\t5_Pais de origen\n\t6_Domicilio\n\t7_Volver");
                Scanner scInt = new Scanner(System.in);
                Scanner scString = new Scanner(System.in);
                int opcion = scInt.nextInt();
                Usuario usuarioAntes = usuario;
                String cambios;
                boolean control = false;

                switch (opcion) {
                    case 1:
                        System.out.println("Nombre actual: " + usuario.getNombre() + "\n\tIngrese su nuevo nombre: ");
                        usuario.setNombre(scString.nextLine());
                        System.out.println("Nombre cambiado con exito! Nuevo nombre : " + usuario.getNombre());
                        System.out.println("\nPresiona cualquier tecla para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                        break;

                    case 2:
                        System.out.println("Apellido actual: " + usuario.getApellido() + "\n\tIngrese su nuevo apellido: ");
                        usuario.setApellido(scString.nextLine());
                        System.out.println("Apellido cambiado con exito! Nuevo apellido :" + usuario.getApellido());
                        System.out.println("\nPresiona cualquier tecla para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                        break;

                    case 3:
                        do {
                            System.out.println("Dni actual: " + usuario.getDni() + "\n\tIngrese su nuevo dni: ");
                            cambios = scString.nextLine();
                            control = true;
                            if (controlDNIEsUnINT(cambios) == false || cambios.length() != 8) {
                                control = false;
                                System.err.println("Ingreso un valor no valido");
                            }
                            if (retornarUsuarioXDni(cambios) != null) {
                                System.err.println("El dni ingresado ya pertenece a un usuario registrado en el sistema");
                                control = false;
                            } else {
                                usuario.setDni(cambios);
                            }
                        } while (control == false);
                        System.out.println("DNI cambiado con exito! Nuevo dni: " + usuario.getDni());
                        System.out.println("\nPresiona cualquier tecla para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                        break;

                    case 4:
                        System.out.println("Edad actual: " + usuario.getEdad() + "\n\tIngrese su nueva edad: ");
                        usuario.setEdad(scString.nextInt());
                        System.out.println("Pais cambiado con exito! Nueva Edad : " + usuario.getEdad());
                        System.out.println("\nPresiona cualquier tecla para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                        break;

                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Las opciones son del 1 al 5");
                }
                actualizarUsuario(usuarioAntes, usuario);
            } catch (java.util.InputMismatchException e) {
                System.err.println("Ingreso una opcion no valida");
            }
        } while (!salir);
    }

    public void actualizarUsuario(Usuario usuarioAntes, Usuario usuario) {
        for (Reserva reservaAux : this.reservas) {
            if (reservaAux.getUsuario().getDni().compareTo(usuarioAntes.getDni()) == 0) {
                reservaAux.setUsuario(usuario);
            }
        }
        for (Usuario usuarioAux : this.usuarios) {
            if (usuarioAux.equals(usuarioAntes)) {
                usuarioAux = usuario;
            }
        }
    }

    public boolean validarUsuario(String dni) {
        if (this.usuarios.size() > 0) {
            for (Usuario user : this.usuarios) {
                if (dni.compareTo(user.getDni()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean controlDNIEsUnINT(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public Usuario retornarUsuarioXDni(String dni) {
        if (this.usuarios.size() > 0) {
            for (Usuario user : this.usuarios) {
                if (dni.compareTo(user.getDni()) == 0) {
                    return user;
                }
            }
        }
        return null;
    }

    ///----RESERVAS----///

    ///TRAMO 1
    public void MenuReserva(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        int op;
        char resp;

        do {
            System.out.println("Seleccione alguna de las siguientes acciones");
            System.out.println("\n1.Contratar Vuelo \n2.Cancelar Vuelo\n3.Mi informacion\n4.Terminar Programa");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    crearReserva(usuario);
                    break;
                case 2:
                    cancelarVuelo(usuario);
                    break;
                case 3:

                case 3:
                    System.exit(0);
                    break;
            }
            System.out.println("DESEA REALIZAR OTRA OPERACION? S/N");
            resp = sc.next().charAt(0);
        } while (resp != 'N');
    }

    public void crearReserva(Usuario usuario) {
        int resp;
        do {
            resp = 0;
            Scanner sc = new Scanner(System.in);
            int acompañantes = 0;
            ArrayList<GastoExtra> gastoExtras = new ArrayList<>();
            Vuelo nuevo;
            Reserva nueva;
            String origen, destino;
            System.out.println("MENU CONTRATACION");
            LocalDate selFecha = seleccionFecha(usuario);
            System.out.println("Ingrese cantidad de acompañantes");
            acompañantes = sc.nextInt();
            Avion selAvion = seleccionAvion(acompañantes, selFecha);

            do {
                System.out.println("Ingrese el numero de la ciudad");
                origen = seleccionCiudad();
                System.out.println("Ingrese el numero de la ciudad");
                destino = seleccionCiudad();
                if (controlCiudad(origen, destino) == true) {
                    System.out.println("Su origine y destino son iguales,por favor,cambie alguno");
                }
            } while (controlCiudad(origen, destino) == true);

            if (selAvion instanceof Silver || selAvion instanceof Gold) {
                gastoExtras = seleccionGastosAdicionales(selAvion);
                nueva = new Reserva(selFecha, origen, destino, selAvion, usuario, acompañantes, gastoExtras);
            } else {
                nueva = new Reserva(selFecha, origen, destino, selAvion, usuario, acompañantes);
            }
            nuevo = new Vuelo(selFecha, origen, destino, selAvion);
            System.out.println("Su Reserva es la siguiente: ");
            System.out.println(nueva.toString());
            System.out.println("Desea confirmarla?");
            resp = sc.nextInt();
            if (resp != 0) {
                actualizarListasVueRes(nueva, nuevo);
            }
        } while (resp != 0);

    }

    public void actualizarListasVueRes(Reserva reserva, Vuelo vuelo) {
        this.vuelos.add(vuelo);
        this.reservas.add(reserva);
    }


    ///SELECCION FECHA
    public boolean fechaDisponible(LocalDate seleccion, Usuario usuario) {
        for (Reserva reservaAux : this.reservas) {
            if (reservaAux.getInicio().equals(seleccion) && reservaAux.getUsuario().equals(usuario)) {
                return false;
            }
        }
        return true;
    }

    public LocalDate seleccionFecha(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        LocalDate seleccion;
        boolean salir;
        do {
            salir = false;
            int anio = 0, mes = 0, dia = 0, hora = 0, minuto = 0;
            char resp;
            System.out.println("-INGRESE A CONTINUACION LOS SIGUIENTES DATOS DE MANERA NUMERICA-");
            System.out.println("EJEMPLO: MES 1 = ENERO,MES 2 = FEBRERO");
            System.out.println("INGRESE AÑO:");
            anio = sc.nextInt();
            System.out.println("INGRESE MES:");
            mes = sc.nextInt();
            System.out.println("INGRESE DIA(CORRESPONDER FINALES EN CADA MES,SEA 30 O 31 EN CUENTA):");
            dia = sc.nextInt();
            System.out.println("INGRESE HORA(FORMATO 24HS):");
            hora = sc.nextInt();
            System.out.println("INGRESE MINUTO(NO SUPERAR 59):");
            minuto = sc.nextInt();

            seleccion = LocalDate.of(anio, mes, dia);
            if (fechaDisponible(seleccion, usuario)) {
                System.out.println("La fecha ingresada esta disponible \n Desea Confirmar? S/N");
                resp = sc.next().charAt(0);
                if (resp == 'S') System.out.println("Fecha confirmada");
                salir = true;
            } else {
                System.out.println("Hay un vuelo programado para esa fecha,por favor ingrese otra");
            }
        } while (salir == false);
        return seleccion;
    }


    //SELECCION AVION
    public ArrayList<Avion> retornarAvionesDispReserva(int acompañante, LocalDate seleccion) {
        ArrayList<Avion> recuperados = new ArrayList<>();
        for (Vuelo vueloAux : this.vuelos) {
            for (Avion avionAux : this.aviones) {
                if (!(vueloAux.getAvion().equals(avionAux)) && (avionAux.getCapMXPasajeros() == acompañante + 1)) {
                    recuperados.add(avionAux);
                }
            }
        }
        return recuperados;
    }

    public Avion seleccionAvion(int acompañante, LocalDate seleccionado) {
        Scanner sc = new Scanner(System.in);
        Avion seleccion;
        boolean salir;
        int index = 0, sel;
        ArrayList<Avion> aviones = retornarAvionesDispReserva(acompañante, seleccionado);
        if (aviones.size() > 0) {
            for (Avion avionAux : aviones) {
                System.out.println(index + avionAux.toString());
                index++;
            }
            System.out.println("Ingrese el numero de avion que desee contratar");
            sel = sc.nextInt();
            return aviones.get(sel);
        } else {
            System.out.println("No se posees aviones disponibles para la fecha");
        }

        return null;
    }

    //SELECCION CIUDAD
    public static String seleccionCiudad() {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        String seleccion;
        for (Vuelo.Ciudades ciudades : Vuelo.Ciudades.values()) {
            System.out.println(index + ciudades.name());
            index++;
        }
        int op = sc.nextInt();
        switch (op) {
            case 1:
                return seleccion = Vuelo.Ciudades.BuenosAires.name();

            case 2:
                return seleccion = Vuelo.Ciudades.Cordoba.name();

            case 3:
                return seleccion = Vuelo.Ciudades.Montevideo.name();

            case 4:
                return seleccion = Vuelo.Ciudades.SantiagoDeChile.name();

            default:
                System.out.println("Solo opciones del 1 a 4");
        }
        return null;
    }

    public static boolean controlCiudad(String origen, String destino) {
        return origen.compareTo(destino) == 0;
    }

    ///SELECCION ADICIONAL
    public static ArrayList<GastoExtra> seleccionGastosAdicionales(Avion seleccion) {
        Scanner sc = new Scanner(System.in);
        int rt, control = 0;
        ArrayList<GastoExtra> gastoExtras = new ArrayList<>();
        System.out.println("MENU GASTOS EXTRAS" +
                "\n ¿Que desea agregar a su vuelo? 1.Platillos \n2. Wi-fi");
        rt = sc.nextInt();
        switch (rt) {
            case 1:
                do {
                    control = 0;
                    GastoExtra gastoExtra = seleccionPlatillo();
                    gastoExtras.add(gastoExtra);
                    System.out.println("Desea cargar alguna mas? 0 para salir");
                    control = sc.nextInt();
                } while (control == 0);
                break;
            case 2:
                if (seleccion instanceof Gold) {
                    System.out.println("Ingrese la cantidad de tiempo que desee contratar el wi fi (150 x Hora)");
                    rt = sc.nextInt();
                    GastoExtra wifi = new GastoExtra("Wi-Fi", rt, 150);
                    gastoExtras.add(wifi);
                } else {
                    System.out.println("Su unidad no posee servicio de Wi fi");
                }
            default:
                System.out.println("Opciones 1 y 2 unicamente");
        }
        return gastoExtras;
    }

    public static GastoExtra seleccionPlatillo() {
        Scanner sc = new Scanner(System.in);
        int sel, cant;
        GastoExtra gastoExtra = null;
        for (Platillos platito : Platillos.values()) {
            System.out.println(platito.toString());
        }
        System.out.println("Ingrese el numero de platillo a agregar");
        sel = sc.nextInt();
        System.out.println("Ingrese la cantidad de platillos a agregar");
        cant = sc.nextInt();
        switch (sel) {
            case 1:
                gastoExtra = new GastoExtra(Platillos.platillo1.getDescripcion(), cant, Platillos.platillo1.getPrecio());
                break;
            case 2:
                gastoExtra = new GastoExtra(Platillos.platillo2.getDescripcion(), cant, Platillos.platillo2.getPrecio());
                break;
            case 3:
                gastoExtra = new GastoExtra(Platillos.platillo3.getDescripcion(), cant, Platillos.platillo3.getPrecio());
                break;
            case 4:
                gastoExtra = new GastoExtra(Platillos.platillo4.getDescripcion(), cant, Platillos.platillo4.getPrecio());
                break;
            case 5:
                gastoExtra = new GastoExtra(Platillos.platillo5.getDescripcion(), cant, Platillos.platillo5.getPrecio());
                break;
            case 6:
                gastoExtra = new GastoExtra(Platillos.platillo6.getDescripcion(), cant, Platillos.platillo6.getPrecio());
                break;
            case 7:
                gastoExtra = new GastoExtra(Platillos.platillo7.getDescripcion(), cant, Platillos.platillo7.getPrecio());
                break;
            case 8:
                gastoExtra = new GastoExtra(Platillos.platillo8.getDescripcion(), cant, Platillos.platillo8.getPrecio());
                break;
            case 9:
                gastoExtra = new GastoExtra(Platillos.platillo9.getDescripcion(), cant, Platillos.platillo9.getPrecio());
                break;
            case 10:
                gastoExtra = new GastoExtra(Platillos.platillo10.getDescripcion(), cant, Platillos.platillo10.getPrecio());
                break;
            default:
                System.out.println("opciones del 1 al 10");
        }
        return gastoExtra;
    }

    ///MENU DE CANCELACION
    public void cancelarVuelo(Usuario cliente) {
        Scanner sc = new Scanner(System.in);
        int index = 0, resp = 0, sel;
        do {
            ArrayList<Reserva> activas = retornarActivas(cliente);
            System.out.println("MENU DE CANCELACION DE VUELO");
            if (activas.size() > 0) {
                System.out.println("A CONTINUACION PODRA VER SUS VUELOS ACTIVOS");
                for (Reserva reserva : activas) {
                    System.out.println(index + reserva.toString());
                }
                System.out.println("INGRESE EL NUMERO DE RESERVA QUE DESEA BORRAR");
                sel = sc.nextInt();
                System.out.println("¿ESTA SEGURO DE BORRAR DICHA RESERVA? 0 PARA REALIZAR");
                resp = sc.nextInt();
                if (resp == 0) {
                    borrarVuelo(activas.get(sel));
                }
                System.out.println("Desea remover otro vuelo? 0 PARA CONFIRMAR");
                resp = sc.nextInt();
            } else {
                System.out.println("USTED NO POSEE RESERVAS ACTIVAS");
                resp = 1;
            }
        } while (resp != 0);
    }

    public void borrarVuelo(Reserva reserva) {
        this.reservas.remove(reserva);
        System.out.println("Vuelo eliminado Satisfactoriamente");
    }

    public ArrayList<Reserva> retornarActivas(Usuario usuario) {
        ArrayList<Reserva> retornados = new ArrayList<>();
        for (Reserva reservaAux : this.reservas) {
            if (reservaAux.getUsuario().equals(usuario)) {
                if (reservaAux.getInicio().isAfter(LocalDate.now())) {
                    retornados.add(reservaAux);
                }
            }
        }
        return retornados;
    }

    ///MENU DE INFORMACION
    public void menuInformacion() {
        Scanner sc = new Scanner(System.in);
        int op = 0, mes, anio,dia;
        System.out.println("-BIENVENIDO AL MENU DE INFORMACION-\n " +
                "Seleccione una de las siguientes opciones:\n " +
                "1.Mostrar vuelos segun una fecha\n" +
                "\n2.Mostrar Clientes" +
                "\n3.");
        op = sc.nextInt();
        switch (op) {
            case 1:
                    System.out.println("-INGRESE A CONTINUACION LOS SIGUIENTES DATOS DE MANERA NUMERICA-");
                    System.out.println("EJEMPLO: MES 1 = ENERO,MES 2 = FEBRERO");
                    do {
                        System.out.println("INGRESE Anio:");
                        anio = sc.nextInt();
                    }while (controlAnio(anio) == false);

                    do {
                        System.out.println("INGRESE MES:");
                        mes = sc.nextInt();
                    }while (controlMes(mes) == false);

                    do {
                        System.out.println("INGRESE DIA(CORRESPONDER FINALES EN CADA MES,SEA 30 O 31 EN CUENTA):");
                        dia = sc.nextInt();
                    }while(controlDia(mes,dia) != false);

                    LocalDate mostrar = LocalDate.of(anio,mes,dia);
                    mostrarVLSegunFecha(mostrar);
                    break;

            case 2:
                mostrarClientes();
                break;
            case 3:


                }
        }


    public void menuMiInformacion(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        Reserva reserva;
        int op = 0, mes, anio,dia;
        System.out.println("-BIENVENIDO AL MENU DE MI INFORMACION-\n " +
                "Seleccione una de las siguientes opciones:\n " +
                "1.Mostrar mi reserva actual\n" +
                "\n2.Mostrar mis reservas activas" +
                "\n3.Mostrar mis reservas antiguas" +
                "\n4.Mostrar el total gastado");
        op = sc.nextInt();
        switch (op) {
            case 1:
                reserva = retornarReservaActual(usuario);
                System.out.println(reserva);
                break;
            case 2:
                
                break;
            case 3:


        }
    }

    public Reserva retornarReservaActual(Usuario usuario){
        Reserva reservaMasChica = retornarPrimera(usuario);
        for(Reserva reserva : this.reservas){
            if(reserva.getUsuario().equals(usuario) && !(reserva.equals(reservaMasChica))){
                if((reserva.getInicio().isBefore(LocalDate.now()) || reserva.getInicio().equals(LocalDate.now())) && reserva.getInicio().isBefore(reservaMasChica.getInicio())){
                    reservaMasChica = reserva;
                }
            }
        }
        return reservaMasChica;
    }

    public Reserva retornarPrimera(Usuario usuario){
        for(Reserva reserva : this.reservas){
            if(reserva.getInicio().isBefore(LocalDate.now()) || reserva.getInicio().equals(LocalDate.now())){
                if(reserva.getUsuario().equals(usuario)){
                        return reserva;
                }

            }
        }
        return null;
    }


    public void mostrarVLSegunFecha(LocalDate fecha) {
        for (Vuelo vl : this.vuelos) {
            if (vl.getInicio().equals(fecha)) {
                System.out.println(vl);
            }
        }
    }

    public  void mostrarClientes() {
        System.out.println("-CLIENTES-");
        for (Usuario us : this.usuarios) {
            System.out.println(us.toString());
        }
    }

    public static void mostrarMayor(int bronze, int silver, int gold) {
        if (bronze > silver && bronze > gold) {
            System.out.println("Bronze es la mejor categoria");
        } else {
            if (bronze == silver && bronze > gold) {
                System.out.println("Bronze y Silver son las mejores categorias");
            } else {
                if (bronze > silver && bronze == gold) {
                    System.out.println("Bronze y Gold son las mejores categorias");
                } else {
                    if (bronze < silver && silver > gold) {
                        System.out.println("Silver es la mejor categoria");
                    } else {
                        if (bronze < silver && silver == gold) {
                            System.out.println("Silver y Gold son las mejores categorias");
                        } else {
                            if (bronze < gold && silver < gold) {
                                System.out.println("Gold es la mejor categoria");
                            } else {
                                if (bronze == gold && silver == gold) {
                                    System.out.println("Las tres categorias son las mejores");
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static boolean controlMes(int mes) {
        if (mes > 0 && mes <= 12) return true;
        return false;
    }

    public static boolean controlDia(int mes,int dia){
        boolean rt = true;
        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(dia == 31){
                    rt = false;
                }
                break;
            case 2:
                if(dia == 28){
                    rt = false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(dia == 30){
                    rt = false;
                }
                break;
        }
        return rt;
    }

    public static boolean controlAnio(int anio){
        if(anio>2012 && anio<2030)return true;
        return false;
    }
}
