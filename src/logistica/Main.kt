package logistica

fun gestionarLogistica() {
    // Uso de Constructor Primario y parámetros nombrados
    val miCamion = Camion(marca = "Volvo", capacidad = 15000.0, ejes = 4)

    // Probando el Setter (si ponemos 20000, se limitará a la capacidad de 15000)
    miCamion.cargaActual = 20000.0

    miCamion.mostrarInfo()
    miCamion.realizarEntrega()
}

fun main() {
    gestionarLogistica()
}