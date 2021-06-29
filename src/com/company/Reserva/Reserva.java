package com.company.Reserva;

import com.company.Aeronaves.Avion;
import com.company.GastosExtras.*;
import com.company.User.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva extends Vuelo {
    protected Usuario usuario;
    protected int cantAcomp;
    protected ArrayList<GastoExtra> gastosExtras;
    protected float costoTotal;

    public Reserva(LocalDate inicio, String origen, String destino,
                   Avion avion, Usuario usuario, int cantAcomp) {
        super(inicio, origen, destino, avion);
        this.usuario = usuario;
        this.cantAcomp = cantAcomp;
        this.gastosExtras = new ArrayList<>();
        this.costoTotal = calcularCostoTotal();
    }

    public Reserva(LocalDate inicio, String origen, String destino,
                   Avion avion, Usuario usuario, int cantAcomp,ArrayList<GastoExtra> gastoExtras) {
        super(inicio, origen, destino, avion);
        this.usuario = usuario;
        this.cantAcomp = cantAcomp;
        this.gastosExtras = gastoExtras;
        this.costoTotal = calcularCostoTotal();
    }


    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCantAcomp() {
        return cantAcomp;
    }
    public void setCantAcomp(int cantAcomp) {
        this.cantAcomp = cantAcomp;
    }

    public ArrayList<GastoExtra> getGastosExtras() {
        return gastosExtras;
    }
    public void setGastosExtras(ArrayList<GastoExtra> gastosExtras) {
        this.gastosExtras = gastosExtras;
    }

    public float getCostoTotal() {
        return costoTotal;
    }
    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }


    public int contarKm(String origen, String destino) {
        int contarKm = 0;

        if(origen.compareTo(Ciudades.BuenosAires.name())==0 || origen.compareTo(Ciudades.Cordoba.name())==0){
            if(destino.compareTo(Ciudades.Cordoba.name())==0 || destino.compareTo(Ciudades.BuenosAires.name())==0){
                contarKm = 695;
            }
        }

        if(origen.compareTo(Ciudades.BuenosAires.name())==0 || origen.compareTo(Ciudades.SantiagoDeChile.name())==0){
            if(destino.compareTo(Ciudades.SantiagoDeChile.name())==0 || destino.compareTo(Ciudades.BuenosAires.name())==0){
                contarKm = 1400;
            }
        }

        if(origen.compareTo(Ciudades.BuenosAires.name())==0 || origen.compareTo(Ciudades.Montevideo.name())==0){
            if(destino.compareTo(Ciudades.Montevideo.name())==0 || destino.compareTo(Ciudades.BuenosAires.name())==0){
                contarKm = 950;
            }
        }

        if(origen.compareTo(Ciudades.Cordoba.name())==0 || origen.compareTo(Ciudades.Montevideo.name())==0){
            if(destino.compareTo(Ciudades.Montevideo.name())==0 || destino.compareTo(Ciudades.Cordoba.name())==0){
                contarKm = 1150;
            }
        }

        if(origen.compareTo(Ciudades.Cordoba.name())==0 || origen.compareTo(Ciudades.SantiagoDeChile.name())==0){
            if(destino.compareTo(Ciudades.SantiagoDeChile.name())==0 || destino.compareTo(Ciudades.Cordoba.name())==0){
                contarKm = 1050;
            }
        }

        if(origen.compareTo(Ciudades.Montevideo.name())==0 || origen.compareTo(Ciudades.SantiagoDeChile.name())==0){
            if(destino.compareTo(Ciudades.SantiagoDeChile.name())==0 || destino.compareTo(Ciudades.Montevideo.name())==0){
                contarKm = 2100;
            }
        }

        return contarKm;
    }

    public float calcularCostoTotal(){
        float costoTotal = 0;
        if(this.gastosExtras.size() > 0){
            for(GastoExtra gastoExtraAux : this.gastosExtras){
                costoTotal = costoTotal +  gastoExtraAux.getCostoTotal();
            }
        }
        costoTotal = costoTotal + ((this.contarKm(this.origen,this.destino)* this.avion.getCostoXKM()) +
                (this.cantAcomp * 3500) + this.avion.getTarifaUnica());

        return costoTotal;
    }
}
