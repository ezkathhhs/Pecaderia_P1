class Jurel (

    nombre: String,
    precioPorKilo: Double,
    stockKilos: Double
                        // Agregar una propiedad específica

) : Pescado(nombre, precioPorKilo, stockKilos) { //Clase de la que heredara

        override fun descripcion(): String{
            return "Jurel : $nombre" +
                    "Precio por Kilo: $$precioPorKilo/kg" +
                    "Stock en Kilos: $stockKilos"
        }

    }
