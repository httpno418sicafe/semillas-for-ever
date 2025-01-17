package ar.edu.unahur.obj2.semillas

open class Menta(override var altura: Double, override val anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || altura > 0.4
    }

    override fun espacioOcupado(): Double {
        return altura + 1
    }

    override fun esParcelaIdeal(parcela: Parcela): Boolean {
        return parcela.superficie() > 6
    }
}

open class Soja(override var altura: Double, override val anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun horasDeSolLimite(): Int {
        var horasLimite: Int = 0
        horasLimite = when  {
            altura < 0.5 -> 6
            altura in 0.5..1.0 -> 8
            else -> { // Note the block
                12
            }
        }
        return horasLimite
    }

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() && altura in 0.75..0.9 && anioSemilla > 2007
    }

    override fun espacioOcupado(): Double {
        return altura/2
    }

    override fun esParcelaIdeal(parcela: Parcela): Boolean {
        return parcela.horasDeSol == this.horasDeSolLimite()
    }
}

class SojaTransgenica(override var altura: Double, override val anioSemilla: Int): Soja(altura,anioSemilla){
    override fun daNuevasSemillas():Boolean{
        return false
    }

    override fun esParcelaIdeal(parcela: Parcela): Boolean {
        return parcela.cantidadMaximaPlantas() == 1
    }
}

class Peperina(override var altura: Double, override val anioSemilla: Int): Menta(altura, anioSemilla){
    override fun espacioOcupado(): Double {
        return super.espacioOcupado() * 2
    }
}

class Quinoa(override var altura: Double, override val anioSemilla: Int, val espacio: Double): Planta(altura, anioSemilla){
    override fun horasDeSolLimite(): Int {
        var horasLimite: Int
        if (espacio < 0.3) {
            horasLimite = 10
        } else {
            horasLimite = 0
        }
        return horasLimite
    }

    override fun espacioOcupado(): Double {
       return espacio
    }

    override fun esParcelaIdeal(parcela: Parcela): Boolean {
        val condicion : (Planta) -> Boolean = {it.altura < 1.5}
        return parcela.plantas.all(condicion)
    }

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() && anioSemilla in 2001..2008
    }

}

abstract class Planta(open var altura: Double, open val anioSemilla: Int) {
    open fun anioSemilla(): Int {
        return anioSemilla
    }
    open fun altura(): Double {
        return altura
    }
    open fun horasDeSolLimite(): Int{
        return 7
    }
    open fun esFuerte(): Boolean{
        return this.horasDeSolLimite() > 9
    }
    open fun daNuevasSemillas(): Boolean{
        return this.esFuerte()
    }
    abstract fun espacioOcupado(): Double
    abstract fun esParcelaIdeal(parcela: Parcela): Boolean
}