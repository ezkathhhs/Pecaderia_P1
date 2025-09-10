class Salmon (

    nombre: String,
    precioPorKilo: Double,
    stockKilos: Double
                        // Agregar una propiedad específica

) : Pescado(nombre, precioPorKilo, stockKilos) {

    override fun descripcion(): String{
        return "Salmon: $nombre" +
                "Precio por Kilo: $$precioPorKilo/kg" +
                "Stock en Kilos: $stockKilos"
    }

}