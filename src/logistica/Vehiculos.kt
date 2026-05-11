package logistica

// 1. INTERFAZ: Define un comportamiento (Contrato)
interface Entregable {
    fun realizarEntrega()
}

// 2. CLASE ABSTRACTA: Define la base de un Vehículo
abstract class Vehiculo(open var marca: String, open var capacidadCarga: Double) {
    abstract val tipoCombustible: String

    // Bloque INIT
    init {
        println("Registrando nuevo vehículo: $marca")
    }
}

// 3. SUBCLASE con HERENCIA y SETTER/GETTER
class Camion(marca: String, capacidad: Double, var ejes: Int = 2) :
    Vehiculo(marca, capacidad), Entregable {

    override val tipoCombustible = "Diesel"

    // Propiedad con Getter y Setter personalizado
    var cargaActual: Double = 0.0
        set(valor) {
            field = if (valor <= capacidadCarga) valor else capacidadCarga
        }

    // Método para mostrar info
    fun mostrarInfo() {
        println("Camión $marca | Ejes: $ejes | Combustible: $tipoCombustible")
        println("Carga: $cargaActual / $capacidadCarga kg")
    }

    override fun realizarEntrega() {
        println("🚚 El camión $marca está en ruta de entrega pesada...")
    }
}