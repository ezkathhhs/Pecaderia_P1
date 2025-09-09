class Jurel (
    nombre: String,
    precioPorKilo: Double,
    stockKilos: Double
) :

    Pescado(nombre, precioPorKilo, stockKilos) {
        override fun descripcion(){
            "Nombre: Jurel"
            super.descripcion()
        }
    }
