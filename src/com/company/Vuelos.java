package com.company;

import com.company.Aeronaves.Aviones;
import com.company.Aeronaves.Bronze;
import com.company.Aeronaves.Gold;
import com.company.Aeronaves.Silver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

public class Vuelos {
    ///ATRIBUTOS
    private LocalDateTime fecha;
    private int acompañantes;
    private int kilometros = 0;
    private Usuario usuario;
    private Aviones aeronave;
    private float importe;
    private Destino destino;
    private Origen origen;

    ///CONSTRUCTOR
    public Vuelos(){}
    public Vuelos(LocalDateTime fecha, int acompañantes, Usuario usuario, Aviones aeronave, Origen origen, Destino destinos) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = ContarKm(origen, destinos);
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.origen = origen;
        this.destino = destinos;
        this.aeronave.setReservado(1);
        this.importe = CalcularCostoTotal(kilometros, aeronave, acompañantes);
    }
 ///Mostrar
    @Override
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", acompañantes=" + acompañantes +
                ", kilometros=" + kilometros +
                ", usuario=" + usuario +
                ", aeronave=" + aeronave+
                ", importe=" + importe +
                ", destino=" + destino +
                ", origen=" + origen +
                '}';
    }

    //ENUM
    public enum Destino {
        Cordoba, Montevideo, Santiago;

    }

    public enum Origen {
        BsAs, Cordoba, Montevideo;
    }

    //METODOS OBTENCION
    public static float CalcularCostoTotal(int kilomentros, Aviones aeronave, int acompañantes) {
        float total = (kilomentros * aeronave.getCostoXKM()) +
                ((acompañantes + 1) * 3500) + (aeronave.getTarifa());
        return total;
    }

    public int ContarKm(Origen origen, Destino destino) {
        if (origen == Origen.BsAs) {
            if (destino == Destino.Cordoba) {
                kilometros = 695;
            }
            if (destino == Destino.Montevideo) {
                kilometros = 950;
            }
            if (destino == Destino.Santiago) {
                kilometros = 1400;
            }
        } else if (origen == Origen.Cordoba) {
            if (destino == Destino.Montevideo) {
                kilometros = 1190;
            }
            if (destino == Destino.Santiago) {
                kilometros = 1050;
            }
        } else if (origen == Origen.Montevideo && destino == Destino.Santiago) {
            kilometros = 2100;
        }
        return kilometros;
    }

    //COMPARACION Y VALIDACION
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Vuelos)) return false;
        Vuelos vl = (Vuelos) obj;
        return this.fecha.equals(vl.fecha) && this.acompañantes == vl.acompañantes &&
                this.kilometros == vl.kilometros && this.usuario.equals(vl.usuario) &&
                this.aeronave.equals(vl.aeronave);
    }

    public static int comprobacionfecha(List<Vuelos> inivue, LocalDateTime seleccion) {
        int i = 0;
        for (Vuelos auxv : inivue) {
            if (seleccion.compareTo(auxv.fecha) == 0) {
                i = 1;
            }
        }
        return i;
    }

    public int validarUsuario(List<Usuario> iniUser, Usuario cliente) {
        int validacion = 0;
        for (Usuario user : iniUser) {
            if (user.equals(cliente) == true) {
                validacion = 1;
            }
        }
        return validacion;
    }

    //SET AND GET
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
    }

    public int getAcompañantes() {
        return acompañantes;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setAeronave(Aviones aeronave) {
        this.aeronave = aeronave;
    }

    public Aviones getAeronave() {
        return aeronave;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public Origen getOrigen() {
        return origen;
    }
}


