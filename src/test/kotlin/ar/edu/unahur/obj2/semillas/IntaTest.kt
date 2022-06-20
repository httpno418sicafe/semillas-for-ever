package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class IntaTest : DescribeSpec({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val inta = Inta()

        val parcela1 = Parcela(3.0, 20.0, 5)
        val parcelaEcologica = ParcelaEcologica(3.0, 0.1, 8)
        val parcelaIndustrial = ParcelaIndustrial(3.0, 20.0, 7)

        val menta = Menta(1.0, 2021)
        val menta2 = Menta(1.0, 2021)
        val menta3 = Menta(1.0, 2021)

        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val soja2 = Soja(2.0, 2009)
        val soja3 = Soja(2.0, 2009)
        val soja4 = Soja(2.0, 2009)


        val peperina = Peperina(1.6, 2021)
        val quinoa = Quinoa(0.3, 2007, 0.1)
        val quinoa2 = Quinoa(0.3, 2021, 0.2)
        val sojaTransgenica = SojaTransgenica(0.6, 2009)

        parcela1.agregarPlanta(peperina)
        parcela1.agregarPlanta(quinoa)
        parcela1.agregarPlanta(soja2)
        parcela1.agregarPlanta(soja3)
        parcela1.agregarPlanta(soja4)

        parcelaEcologica.agregarPlanta(menta)
        parcelaEcologica.agregarPlanta(sojaTransgenica)

        parcelaIndustrial.agregarPlanta(mentita)
        parcelaIndustrial.agregarPlanta(soja)
        parcelaIndustrial.agregarPlanta(quinoa2)
        parcelaIndustrial.agregarPlanta(menta2)
        parcelaIndustrial.agregarPlanta(menta3)

        inta.agregarParcela(parcela1)
        inta.agregarParcela(parcelaEcologica)
        inta.agregarParcela(parcelaIndustrial)


        it("verificar si agrega parcelas") {
            inta.parcelas.size.shouldBe(3)
        }
        it("promedio de plantas por parcela") {
            inta.promedioPlantasPorParcela().shouldBe(4)
        }
        it("mas autosustentable") {
            inta.parcelaMasSustentable().shouldBe(parcela1)
        }
    }
})