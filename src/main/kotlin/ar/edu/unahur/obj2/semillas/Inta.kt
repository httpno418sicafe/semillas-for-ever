package ar.edu.unahur.obj2.semillas
import  ar.edu.unahur.obj2.semillas.Parcela

class Inta () {
    var parcelas: MutableList<Parcela> = mutableListOf<Parcela>()

    fun agregarParcela(parcela: Parcela){
        parcelas.add(parcela)
    }

    fun promedioPlantasPorParcela(): Int{
        var totalPlantas = 0
        for (parcela: Parcela in parcelas) {
            totalPlantas += parcela.plantas.count()
        }
        return totalPlantas / parcelas.size
    }

    fun parcelaMasSustentable(): Parcela? {
        val condicion : (Parcela) -> Boolean = {it.plantas.size > 4}
        var parcelasElegibles = parcelas.filter(condicion)

        return parcelasElegibles.maxByOrNull{it.porcentajeAsociadas()}
    }


}