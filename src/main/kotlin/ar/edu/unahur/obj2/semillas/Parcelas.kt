package ar.edu.unahur.obj2.semillas

import kotlin.math.floor

class Parcela(val largo: Double, val ancho: Double, val horasDeSol: Int) {
    var plantas: MutableList<Planta> = mutableListOf<Planta>()

    fun agregarPlanta(planta: Planta) {
        if(this.cantidadMaximaPlantas() > plantas.size || planta.horasDeSolLimite() >= horasDeSol - 2) {
            plantas.add(planta)
        } else {
            error("Error al Plantar.")
        }
    }

    fun superficie(): Double{
        return ancho * largo
    }

    fun cantidadMaximaPlantas(): Int{
        var cantidadLimite: Int
        if(ancho > largo) {
            cantidadLimite = floor(this.superficie() / 5).toInt()
        } else {
            cantidadLimite = floor(this.superficie() / 3).toInt()
        }
        return cantidadLimite
    }

    fun tieneComplicaciones(): Boolean {
        val condicion : (Planta) -> Boolean = {it.horasDeSolLimite() < horasDeSol}
        return plantas.any(condicion)
    }
}