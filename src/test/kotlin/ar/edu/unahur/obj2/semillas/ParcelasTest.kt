package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest: DescribeSpec ({
    describe("Creación de las plantas") {
        val soja1 = Soja(1.0, 2009)
        val soja2 = Soja(1.0, 2009)
        val soja3 = Soja(1.0, 2009)
        val soja4 = Soja(1.0, 2009)
        val soja5 = Soja(1.0, 2009)

        val parcela1 = Parcela(1.0, 20.0,10)
        parcela1.agregarPlanta(soja1)
        parcela1.agregarPlanta(soja2)
        parcela1.agregarPlanta(soja3)
        parcela1.agregarPlanta(soja4)


        it("Probar agregando plantas"){
            parcela1.tieneComplicaciones().shouldBeFalse()
        }
        it("Limite plantas superado"){
            parcela1.agregarPlanta(soja5).shouldThrow<Exception>()
        }
})