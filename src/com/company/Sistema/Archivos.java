package com.company.Sistema;

import com.company.Aeronaves.Avion;
import com.company.Reserva.Reserva;
import com.company.Reserva.Vuelo;
import com.company.User.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos {

        ///----USUARIOS----///
        public static void agregarUsuario(ArrayList<Usuario>usuarios) throws IOException {
            ObjectMapper JSON_MAPPER = new ObjectMapper();
            JSON_MAPPER.writeValue(new File("Usuarios.json"),usuarios);
        }

        public static ArrayList<Usuario> leerUsuarios() throws IOException {
            ObjectMapper JSON_MAPPER = new ObjectMapper();
            ArrayList<Usuario> usuarios = JSON_MAPPER .readValue("Usuarios.json",
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class,Usuario.class));
            return usuarios;
        }

        ///----RESERVAS----///
        public static void agregarReservas(ArrayList<Reserva> reservas) throws IOException {
                ObjectMapper JSON_MAPPER = new ObjectMapper();
                JSON_MAPPER.writeValue(new File("Reservas.json"),reservas);
            }

        public static ArrayList<Reserva> leerReservas() throws IOException {
            ObjectMapper JSON_MAPPER = new ObjectMapper();
            ArrayList<Reserva> reservas = JSON_MAPPER .readValue("Reservas.json",
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class,Reserva.class));
            return reservas;
        }

        ///----VUELOS----///
        public static void agregarVuelos(ArrayList<Vuelo> vuelos) throws IOException {
                ObjectMapper JSON_MAPPER = new ObjectMapper();
                JSON_MAPPER.writeValue(new File("Vuelos.json"),vuelos);
            }

        public static ArrayList<Vuelo> leerVuelos() throws IOException {
            ObjectMapper JSON_MAPPER = new ObjectMapper();
            ArrayList<Vuelo> vuelos = JSON_MAPPER .readValue("Vuelos.json",
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class,Vuelo.class));
            return vuelos;
        }


        ///----AVIONES----///

        public static void agregarAviones(ArrayList<Avion> aviones) throws IOException {
                ObjectMapper JSON_MAPPER = new ObjectMapper();
                JSON_MAPPER.writeValue(new File("Aviones.json"),aviones);
            }

        public static ArrayList<Avion> leerAviones() throws IOException {
            ObjectMapper JSON_MAPPER = new ObjectMapper();
            ArrayList<Avion> aviones = JSON_MAPPER .readValue("Aviones.json",
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class,Avion.class));
            return aviones;
        }

}
