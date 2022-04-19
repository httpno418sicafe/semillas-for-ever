package ar.edu.unahur.obj2.semillas

class Inta () {
    var parcelas: MutableList<Parcela> = mutableListOf<Parcela>()

    fun agregarParcela(parcela: Parcela){
        parcelas.add(parcela)
    }

    fun promedioPlantasPorParcela(): Float{
        var totalPlantas: Float = 0
        for (parcela: Parcela in parcelas) {
            totalPlantas += parcela.plantas.count()
        }
        return totalPlantas / parcelas.size
    }

    fun parcelaMasSustentable(): Parcela{
        var parcelaMasAutosustentable: Parcela = Parcela(1.0,1.0,1)
        val condicion : (Parcela) -> Boolean = {it.plantas.size > 4}
        var parcelasElegibles = parcelas.filter(condicion)

        for (parcela in parcelasElegibles)
            if (porcentajeAsociadas(parcela) > porcentajeAsociadas(parcelaMasAutosustentable)){
                parcelaMasAutosustentable = parcela
            }
        return parcelaMasAutosustentable
    }

    private fun porcentajeAsociadas(parcela: Parcela): Int {
        var counterAsociadas: Int = 0
        for (planta in parcela.plantas){
            if(parcela.seAsociaBien(planta))
                counterAsociadas += 1
        }
        return counterAsociadas / parcela.plantas.size
    }
}