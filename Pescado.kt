abstract class Pescado (
    val nombre: String,
    val precioPorKilo: Double,
    val stockKilos: Double
){
    init {
        require(nombre.isNotBlank()) { "Debe ingresar el nombre del pescado" }
        require(precioPorKilo > 0) {"El precio debe ser mayor a 0"}
        require(stockKilos > 0) {"El stock en kilos no puede ser menor a 0"}
    }

    open fun descripcion(){
        println("Precio por Kilo: $precioPorKilo" +
                "Stock en Kilos: $stockKilos")
    }
}