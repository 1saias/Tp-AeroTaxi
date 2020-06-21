package com.company;

import com.company.Aeronaves.Aviones;
import com.company.Aeronaves.Bronze;
import com.company.Aeronaves.Gold;
import com.company.Aeronaves.Silver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelos {
    private LocalDateTime fecha;
    private  int acompañantes;
    private  int kilometros;
    private  Usuario usuario;
    private Aviones aeronave;
    private float importe;
    private Destino destino;
    private Origen origen;

    private Ciudades Origen;
    private Destinos destinos;

    public enum Destino{
        Cordoba,Montevideo,Santiago;

    }
    public enum  Origen {
        BsAs, Cordoba, Montevideo;
    }

    public void setFecha(LocalDateTime fecha){
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

    public enum Ciudades{
        BsAs,Cordoba,Montevideo
    }
    public enum Destinos{
        Cordoba,Santiago,Montevideo
    }


    public Vuelos(LocalDateTime fecha, int acompañantes,int kilomentros, Usuario usuario, Aviones aeronave, Ciudades Origen, Destinos destinos) {
        this.fecha = fecha;
        this.acompañantes = acompañantes;
        this.kilometros = kilomentros;
        this.usuario = usuario;
        this.aeronave = aeronave;
        this.Origen = Origen;
        this.destinos = destinos;
        this.aeronave.setReservado(1);
    }

    public float CalcularCostoTotal(int kilomentros,Aviones aeronave,int acompañantes){
        float total = (kilomentros * aeronave.getCostoXKM())+
                ((acompañantes+1)*3500) + (aeronave.getTarifa());
        return total;
    }
    
    public float getImporte() {
        return importe;
    }
    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof Vuelos))return false;
        Vuelos vl=(Vuelos)obj;
        return this.fecha.equals(vl.fecha) && this.acompañantes == vl.acompañantes &&
                this.kilometros == vl.kilometros && this.usuario.equals(usuario) &&
                this.aeronave.equals(aeronave);
    }

    public int comprobacionfecha(ArrayList<Vuelos> vuelos, LocalDateTime seleccion){
        int i =0;
        for(Vuelos auxv : vuelos ){
            if(seleccion.compareTo(auxv.fecha)==0){
                i=1;
            }
        }
        return i;
    }

    public void mostrarAvionesDisponibles(ArrayList<Aviones> flota){
        for(Aviones avion : flota){
                if(avion.getReservado() == 0){
                    if(avion instanceof Bronze){
                        System.out.println(avion.toString());
                    }else{
                        if(avion instanceof Silver){
                            System.out.println(avion.toString());
                        }else{
                            if(avion instanceof Gold){
                                System.out.println(avion.toString());
                            }
                        }
                    }
                }
            }
        }

        public int validarUsuario(ArrayList<Usuario> usuarios,Usuario usuario){
        int validacion=0;
            for(Usuario user : usuarios){
                if(user.equals(usuario)==true){
                        validacion =1;
                }
            }
            return validacion;
        }

    @Override
    public String toString() {
        return "Vuelos{" +
                "fecha=" + fecha +
                ", acompañantes=" + acompañantes +
                ", kilomentros=" + kilometros +
                ", usuario=" + usuario +
                ", aeronave=" + aeronave +
                '}';
    }

   /* public int TotalDeKm(Ciudades origen,Destinos destinos) {
        if (origen.equals(destinos) )
        {
            System.out.println("Ingrese un destino valido");

        }
    }*/

}
