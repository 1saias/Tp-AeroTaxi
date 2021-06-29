package com.company.Reserva;

import com.company.Aeronaves.Avion;
import com.company.Sistema.Archivos;
import com.company.User.Usuario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    protected LocalDate inicio;
    protected String origen;
    protected String destino;
    protected Avion avion;

        public Vuelo(LocalDate inicio, String origen, String destino, Avion avion) {
            this.inicio = inicio;
            this.origen = origen;
            this.destino = destino;
            this.avion = avion;
        }

        ////-----CONSTRUCTOR-----////

        public LocalDate getInicio() {
            return this.inicio;
        }
        public void setInicio(LocalDate inicio) {
            this.inicio = inicio;
        }

        public String getOrigen() {
            return this.origen;
        }
        public void setOrigen(String origen) {
            this.origen = origen;
        }

        public String getDestino() {
            return this.destino;
        }
        public void setDestino(String destino) {
            this.destino = destino;
        }

        public Avion getAvion() {
            return this.avion;
        }
        public void setAvion(Avion avion) {
            this.avion = avion;
        }


        //ENUM
        public enum Ciudades {
            BuenosAires,
            Cordoba,
            Montevideo,
            SantiagoDeChile;
        }

}



