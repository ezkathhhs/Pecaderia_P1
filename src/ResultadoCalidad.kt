// Sealed class (clase sellada) que representa los posibles resultados del control de calidad
// Las sealed classes son ideales para representar un conjunto limitado de tipos
sealed class ResultadoCalidad {
    // Clase de datos para representar un resultado exitoso
    // data class nos da automáticamente toString(), equals(), hashCode() y copy()
    data class Exitoso(
        val mensaje: String,      // Mensaje descriptivo del resultado
        val puntuacion: Int       // Puntuación numérica de la calidad (0-100)
    ) : ResultadoCalidad()        // Hereda de ResultadoCalidad

    // Clase de datos para representar un resultado con error
    data class Error(
        val motivo: String,       // Razón del error o problema detectado
        val severidad: String     // Nivel de severidad (BAJA, MEDIA, ALTA)
    ) : ResultadoCalidad()        // Hereda de ResultadoCalidad
}