package com.company.GastosExtras;

public class GastoExtra {
    private String nombre;
    private int cantidad;
    private float costoUnitario;
    private float costoTotal;

        public GastoExtra(String nombre, int cantidad, float costoUnitario) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.costoUnitario = costoUnitario;
            this.costoTotal = calcularCostoTotal();
        }

        public String getNombre() {
            return this.nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCantidad() {
            return this.cantidad;
        }
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public float getCostoUnitario() {
            return this.costoUnitario;
        }
        public void setCostoUnitario(float costoUnitario) {
            this.costoUnitario = costoUnitario;
        }

        public float getCostoTotal() {
            return this.costoTotal;
        }
        public void setCostoTotal(float costoTotal) {
            this.costoTotal = costoTotal;
        }

        public float calcularCostoTotal(){
            return this.cantidad * this.costoUnitario;
        }


}
