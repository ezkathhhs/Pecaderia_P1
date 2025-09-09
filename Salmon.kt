class Salmon (
    nombre: String,
    precioPorKilo: Double,
    stockKilos: Double
) :

    Pescado(nombre, precioPorKilo, stockKilos) {
    override fun descripcion(){
        "Nombre: Salmon"
        super.descripcion()
    }
}