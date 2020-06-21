package com.company;

import com.company.Aeronaves.Aviones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ControlSistema {
    public void inicializarSistema(){
        FuncionesAuxiliares herramienta = new FuncionesAuxiliares();
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
        Usuario UsAux = new Usuario(nombre,apellido,dni,edad);

        if(herramienta.validarUsuario(iniUser,UsAux)==1){
            System.out.println("El usuario existe,el login fue exitoso");
        }else{
            System.out.println("El usuario no existe,entonces,su registro fue exitoso");
            iniUser.add(UsAux);
        }
    }

    public void inicializarMenuPrincSeleccion(List<Aviones> iniAvi,List<Usuario> iniUser){
        System.out.println("Seleccione alguna de las siguientes acciones");
    }

}
