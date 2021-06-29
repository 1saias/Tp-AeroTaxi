package com.company.GastosExtras;

public enum Platillos {
    platillo1(11f," Bistec con salsa de vino de Oporto y mantequilla con pimienta"),
    platillo2(70f,"Carrillera de ternera con salsa de anchoa y chile"),
    platillo3(98,"Salmón ahumado con carne de cangrejo y caviar"),
    platillo4(55,"Pollo gratinado con cebolla"),
    platillo5(76,"Paté de pollo con foie gras,filete de bacalao con nabo y salsa beurre blanc"),
    platillo6(90,"Langosta atlántica con salsa de coco al curry, arroz negro y Bok Choy"),
    platillo7(69,"Chuleta de cordero provenzal con pesto de calabacín, tomate y polenta de queso"),
    platillo8(72,"Lomo de res con pimienta con arándano, calabaza y crema de espinacas"),
    platillo9(32,"Choripan"),
    platillo10(120,"Salmón asado con zumaque, ensalada de quinoa con aderezo de yogurt de tahini, seguido de pierna de cordero con puré de kumara dorado, judías verdes, espinacas y guisantes con gelatina de menta y manzana, y termina con pannacotta de chocolate blanco y agua de rosas con crema de pistacho");
    private float precio;
    private String descripcion;


        Platillos(float precio,String descripcion){
            this.precio = precio;
            this.descripcion = descripcion;
        }

        public float getPrecio() {
            return this.precio;
        }
        public void setPrecio(float precio) {
            this.precio = precio;
        }

        public String getDescripcion() {
            return this.descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return "\nPlatillo: " + this.name() +
                    "\nPrecio: " + this.precio +
                    "\nDescripcion: " +this.descripcion;
        }
}
