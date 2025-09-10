import kotlinx.coroutines.delay

class PescadoService {

    // Crear lista mutable para almacenar todos los pescados registrados
    private val pescados = mutableListOf<Pescado>()

    // Función para registrar un nuevo pescado con try & catch
    fun registrarPescado(pescado: Pescado) {
        try {
            pescados.add(pescado)  // Agrega el pescado a la lista
            println("✅ Pescado registrado exitosamente: ${pescado.nombre}")
        } catch (e: Exception) {
            // Captura cualquier excepción durante el registro
            println("❌ Error al registrar pescado: ${e.message}")
        }
    }

    // Función para mostrar todos los pescados registrados
    fun mostrarPescados() {
        println("\n📋 LISTA DE PESCADOS REGISTRADOS:")
        println("=".repeat(60))

        // Verifica si la lista está vacía
        if (pescados.isEmpty()) {
            println("No hay pescados registrados")
            return
        }

        // Itera sobre la lista de pescados con índice
        pescados.forEachIndexed { index, pescado ->
            println("${index + 1}. ${pescado.descripcion()}")
        }
    }

    // Función para filtrar pescados con precio mayor a $5000
    fun filtrarPescadosCaros(): List<Pescado> {
        // filter para crear una nueva lista solo con pescados que cumplen la condición
        return pescados.filter { it.precioPorKilo > 5000 }
    }

    // Función para calcular el valor total del stock
    fun calcularValorTotalStock(): Double {
        // sumOf para sumar el producto de precio * stock de cada pescado
        return pescados.sumOf { it.precioPorKilo * it.stockKilos }
    }

    // Función suspendida (corrutina) para simular control de calidad
    suspend fun controlarCalidad(pescado: Pescado): ResultadoCalidad {
        println("🔍 Iniciando control de calidad para: ${pescado.nombre}...")

        // Simula un proceso lento con delay (2 segundos)
        // delay() es una función suspendida que no bloquea el hilo principal
        delay(2000)

        // Lógica para determinar el resultado basado en condiciones del pescado
        return when {
            // Si el stock es 0 o negativo, retorna Error
            pescado.stockKilos <= 0 -> ResultadoCalidad.Error(
                "Stock agotado",
                "ALTA"
            )
            // Pescados muy caros son considerados premium
            pescado.precioPorKilo > 10000 -> ResultadoCalidad.Exitoso(
                "Producto premium - Calidad excelente",
                95
            )
            // Pescados caros son de buena calidad
            pescado.precioPorKilo > 5000 -> ResultadoCalidad.Exitoso(
                "Producto de buena calidad",
                85
            )
            // Pescados económicos son estándar
            else -> ResultadoCalidad.Exitoso(
                "Producto estándar - Calidad aceptable",
                75
            )
        }
    }

    // Función para obtener una copia inmutable de la lista de pescados
    fun getPescados(): List<Pescado> = pescados.toList()
}