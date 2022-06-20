package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daNuevasSemillas().shouldBeTrue()
            mentita.daNuevasSemillas().shouldBeFalse()
            soja.daNuevasSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacioOcupado().shouldBe(2.0)
            mentita.espacioOcupado().shouldBe(1.3)
            soja.espacioOcupado().shouldBe(0.3)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacioOcupado(),
                menta.espacioOcupado(),
                mentita.espacioOcupado()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }
    }
})

class VariantesSemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val peperina = Peperina(1.0, 2021)
        val quinoa = Quinoa(0.3, 2007, 0.1)
        val quinoa2 = Quinoa(0.3, 2021, 0.5)
        val sojaTransgenica = SojaTransgenica(0.6, 2009)

        it("probamos los atributos altura, anioSemilla y espacio") {
            peperina.altura.shouldBe(1.0)
            peperina.anioSemilla.shouldBe(2021)
            quinoa.espacioOcupado().shouldBe(0.1)
            quinoa2.espacioOcupado().shouldBe(0.5)
        }

        it("verificar si da semillas") {
            peperina.daNuevasSemillas().shouldBeTrue()
            quinoa2.daNuevasSemillas().shouldBeFalse()
            quinoa.daNuevasSemillas().shouldBeTrue()
            sojaTransgenica.daNuevasSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            peperina.esFuerte().shouldBeFalse()
            sojaTransgenica.esFuerte().shouldBeFalse()
        }
        it("horas de luz"){
            quinoa2.horasDeSolLimite().shouldBe(0)
            quinoa.horasDeSolLimite().shouldBe(10)
        }

        it("espacio") {
            peperina.espacioOcupado().shouldBe(4.0)
            quinoa.espacioOcupado().shouldBe(0.1)
            sojaTransgenica.espacioOcupado().shouldBe(0.3)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                sojaTransgenica.espacioOcupado(),
                peperina.espacioOcupado(),
                peperina.espacioOcupado()
            ).sum()
            Math.ceil(superficie).shouldBe(9.0)
        }
    }
})