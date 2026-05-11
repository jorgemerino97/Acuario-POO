package acuario

import kotlin.math.PI

open class Acuario(
    open var largo: Int = 100,
    open var ancho: Int = 20,
    open var alto: Int = 40
) {

    open val forma = "rectángulo"

    open var volumen: Int
        get() = ancho * alto * largo / 1000
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    open var agua: Double = 0.0
        get() = volumen * 0.9

    init {
        println("inicializando acuario")
    }

    constructor(numeroDePeces: Int) : this() {
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm " +
                "Largo: $largo cm " +
                "Alto: $alto cm ")
        println("Volumen: $volumen l Agua: $agua l (${agua / volumen * 100.0}% lleno)")
    }
}

class TanqueTorre(override var alto: Int, var diametro: Int) :
    Acuario(largo = diametro, ancho = diametro, alto = alto) {

    override var volumen: Int
        get() = (ancho / 2 * largo / 2 * alto / 1000.0 * PI).toInt()
        set(valor) {
            alto = ((valor * 1000 / PI) / (ancho / 2 * largo / 2)).toInt()
        }

    override var agua = volumen * 0.8
    override val forma = "cilindro"
}