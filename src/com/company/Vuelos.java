package com.company;

import com.company.Aeronaves.Aviones;
import com.company.Aeronaves.Bronze;
import com.company.Aeronaves.Gold;
import com.company.Aeronaves.Silver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelos {
///ATRIBUTOS
    private LocalDateTime fecha;
    private int acompañantes;
    private int kilometros=0;
    private Usuario usuario;
    private Aviones aeronave;
    private float importe;
    private Destino destino;
    private Origen origen;

///CONSTRUCTOR
    public Vuelos(LocalDateTime fecha, int acompañantes, int kilomentros, Usuario usuario, Aviones aeronave, Origen origen, Destino destinos) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = ContarKm(origen,destinos);
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.origen = origen;
        this.destino = destinos;
        this.aeronave.setReservado(1);
        this.importe = CalcularCostoTotal(kilomentros, aeronave, acompañantes);
    }

//ENUM
    public enum Destino {
        Cordoba, Montevideo, Santiago;

    }
    public enum Origen {
        BsAs, Cordoba, Montevideo;
    }
//METODOS OBTENCION
    public float CalcularCostoTotal(int kilomentros, Aviones aeronave, int acompañantes) {
        float total = (kilomentros * aeronave.getCostoXKM()) +
                ((acompañantes + 1) * 3500) + (aeronave.getTarifa());
        return total;
    }

    public int ContarKm(Origen origen,Destino destino) {
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
        }else  if (origen == Origen.Montevideo && destino == Destino.Santiago){
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
                this.kilometros == vl.kilometros && this.usuario.equals(usuario) &&
                this.aeronave.equals(aeronave);
    }

    public static int comprobacionfecha(ArrayList<Vuelos> vuelos, LocalDateTime seleccion) {
        int i = 0;
        for (Vuelos auxv : vuelos) {
            if (seleccion.compareTo(auxv.fecha) == 0) {
                i = 1;
            }
        }
        return i;
    }


    public int validarUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
        int validacion = 0;
        for (Usuario user : usuarios) {
            if (user.equals(usuario) == true) {
                validacion = 1;
            }
        }
        return validacion;
    }
    ///MOSTRAR
    /*public void mostrarAvionesDisponibles(ArrayList<Aviones> flota, Aviones seleccion) {
        for (Aviones avion : flota) {
            if (avion.getReservado() == 0) {
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
    }*/

    @Override
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", acompañantes=" + acompañantes +
                ", kilometros=" + kilometros +
                ", importe=" + importe +
                ", destino=" + destino +
                ", origen=" + origen +
                ", aeronave=" + aeronave +
                ", usuario=" + usuario +
                '}';
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
