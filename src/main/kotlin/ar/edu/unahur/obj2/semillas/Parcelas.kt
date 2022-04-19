package ar.edu.unahur.obj2.semillas

import kotlin.math.floor

open class Parcela(open val largo: Double, open val ancho: Double, open val horasDeSol: Int) {
    var plantas: MutableList<Planta> = mutableListOf<Planta>()

    fun agregarPlanta(planta: Planta) {
        if(this.cantidadMaximaPlantas() > plantas.size && planta.horasDeSolLimite() >= horasDeSol - 2) {
            plantas.add(planta)
        } else {
            throw Exception("Error al Plantar.")
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

class ParcelaEcologica(override val largo: Double, override val ancho: Double, override val horasDeSol: Int): Parcela (largo,ancho,horasDeSol){
    fun seAsociaBien(planta: Planta):Boolean{
        return this.tieneComplicaciones() and planta.esParcelaIdeal(this)
    }
}

class ParcelaIndustrial(override val largo: Double, override val ancho: Double, override val horasDeSol: Int): Parcela (largo,ancho,horasDeSol){
    fun seAsociaBien(planta: Planta):Boolean{
        return (plantas.size <= 2) and planta.esFuerte()
    }
}