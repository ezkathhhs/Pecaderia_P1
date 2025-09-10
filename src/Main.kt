import kotlinx.coroutines.runBlocking  // Para ejecutar corrutinas en el main

// Función principal envuelta en runBlocking para usar corrutinas
fun main() = runBlocking {
    // Crea una instancia del servicio de pescados
    val pescadoService = PescadoService()

    println("🐟 SISTEMA DE GESTIÓN DE PESCADOS 🐟")
    println("=".repeat(40))

    // 1. REGISTRO DE PESCADOS con manejo de errores
    try {
        // Registra diferentes tipos de pescados usando herencia
        pescadoService.registrarPescado(Salmon("Salmón Atlántico", 12000.0, 50.0))
        pescadoService.registrarPescado(Jurel("Reineta", 4500.0, 30.0))
        pescadoService.registrarPescado(Salmon("Salmón del Pacífico", 8500.0, 25.0))
        pescadoService.registrarPescado(Jurel("Corvina", 3500.0, 40.0))

        // Ejemplo de registro que fallaría
        pescadoService.registrarPescado(Salmon("Pez inválido", -100.0, 10.0))

    } catch (e: Exception) {
        println("❌ Error en registro: ${e.message}")
    }

    // 2. MOSTRAR TODOS LOS PESCADOS registrados
    pescadoService.mostrarPescados()

    // 3. FILTRAR PESCADOS CAROS (más de $5000)
    println("\n💰 PESCADOS CAROS (más de $5000):")
    println("=".repeat(50))
    val pescadosCaros = pescadoService.filtrarPescadosCaros()

    // Verifica si hay pescados caros
    if (pescadosCaros.isEmpty()) {
        println("No hay pescados con precio mayor a \$5000")
    } else {
        // Muestra cada pescado caro con su descripción
        pescadosCaros.forEachIndexed { index, pescado ->
            println("${index + 1}. ${pescado.descripcion()}")
        }
    }

    // 4. CALCULAR VALOR TOTAL del stock
    val valorTotal = pescadoService.calcularValorTotalStock()
    // Formatea el valor a 2 decimales
    println("\n💰 VALOR TOTAL DEL STOCK: $${"%.2f".format(valorTotal)}")

    // 5. CONTROL DE CALIDAD con corrutinas
    println("\n🎯 CONTROL DE CALIDAD:")
    println("=".repeat(30))

    // Obtiene todos los pescados registrados
    val pescados = pescadoService.getPescados()

    // Itera sobre cada pescado y realiza control de calidad
    for (pescado in pescados) {
        // Llama a la función suspendida controlarCalidad
        val resultado = pescadoService.controlarCalidad(pescado)

        // Usa when para manejar los diferentes tipos de ResultadoCalidad
        when (resultado) {
            // Si es Exitoso, muestra mensaje y puntuación
            is ResultadoCalidad.Exitoso -> {
                println("✅ ${pescado.nombre}: ${resultado.mensaje} (Puntuación: ${resultado.puntuacion}/100)")
            }
            // Si es Error, muestra motivo y severidad
            is ResultadoCalidad.Error -> {
                println("❌ ${pescado.nombre}: ERROR - ${resultado.motivo} (Severidad: ${resultado.severidad})")
            }
        }
        println("-".repeat(50))  // Línea separadora
    }

    println("\n🎉 Proceso completado exitosamente!")
}