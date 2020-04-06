package org.example

import org.junit.Test
import kotlin.test.assertEquals

class ConversorTest {
/*
    Programar un objeto que permita convertir de millas a kilómetros.
    Programar un objeto que permita convertir de kilómetros a millas.
    Programar un objeto que permita convertir bidireccionalmente millas <-> kilómetros.
    Programar un objeto que permita convertir de una unidad cualquiera a otra.
        Para ello se deberá programar un conversor genérico que sea capaz de recibir el tipo de conversión deseada.
 */
    @Test fun `convierto 20 millas a kilometros`() {
        var millas: Double = 20.00
        val kms = ConversorM.convert(millas)
        assertEquals(32.1868, kms)
}
    @Test fun `convierto 20 kilometros a millas`() {
        var kms: Double = 20.00
        val millas = ConversorK.convert(kms)
        assertEquals(12.42742, millas)
    }

    @Test fun `convierto 20 millas a kilometros y viceversa`() {
        var millas: Unidad = Unidad(UnidadName.MILLAS,20.00, mutableMapOf(Pair(UnidadName.MILLAS, 1.00)))
        var kms: Unidad = Unidad(UnidadName.KILOMETROS,20.00, mutableMapOf(Pair(UnidadName.KILOMETROS, 1.00)))
        val resultKms = ConversorBi.convertBi(millas)
        assertEquals(32.1868, resultKms)
        val resultMillas = ConversorBi.convertBi(kms)
        assertEquals(12.42742,resultMillas)
    }

    @Test fun `convierto 20 UNIDAD GENERICA a MISMA UNIDAD`() {
        var millas: Unidad = Unidad(UnidadName.MILLAS,20.00, mutableMapOf(Pair(UnidadName.MILLAS, 1.00)))
        var kms: Unidad = Unidad(UnidadName.KILOMETROS,20.00, mutableMapOf(Pair(UnidadName.KILOMETROS, 1.00)))
        val resultMillas = ConversorGen.convertGen(millas, UnidadName.MILLAS)
        assertEquals(20.00, resultMillas)
        val resultKms = ConversorGen.convertGen(kms, UnidadName.KILOMETROS)
        assertEquals(20.00,resultKms)
    }

    @Test fun `convierto 20 UNIDAD GENERICA a OTRA UNIDAD`() {
        var millas: Unidad = Unidad(UnidadName.MILLAS, 20.00, mutableMapOf(Pair(UnidadName.MILLAS, 1.00)))
        millas.verCotizaciones()
        millas.agregarCotizacion(UnidadName.KILOMETROS, 1.60934)
        millas.verCotizaciones()
        var kms: Unidad = Unidad(UnidadName.KILOMETROS, 20.00, mutableMapOf(Pair(UnidadName.KILOMETROS, 1.00)))
        kms.verCotizaciones()
        kms.agregarCotizacion(UnidadName.MILLAS, 0.621371)
        kms.verCotizaciones()
        val resultMillas = ConversorGen.convertGen(millas, UnidadName.KILOMETROS)
        assertEquals(32.1868, resultMillas)
        val resultKms = ConversorGen.convertGen(kms, UnidadName.MILLAS)
        assertEquals(12.42742, resultKms)
    }

    @Test fun `convierto 29000 DOLARES a PESOS ARGENTINOS OFICIALES Y BLUE`() {
        var dolares: Unidad = Unidad(UnidadName.DOLARES, 29000.00, mutableMapOf(Pair(UnidadName.DOLARES, 1.00)))
        dolares.verCotizaciones()
        dolares.agregarCotizacion(UnidadName.PESOS, 61.51)
        dolares.verCotizaciones()
        var dolaresBlue: Unidad = Unidad(UnidadName.DOLARESBLUE, 29000.00, mutableMapOf(Pair(UnidadName.DOLARESBLUE, 1.00)))
        dolaresBlue.verCotizaciones()
        dolaresBlue.agregarCotizacion(UnidadName.PESOS, 78.50)
        dolaresBlue.verCotizaciones()
        var pesos: Unidad = Unidad(UnidadName.PESOS,2000000.00, mutableMapOf(Pair(UnidadName.PESOS, 1.00)))
        pesos.verCotizaciones()
        pesos.agregarCotizacion(UnidadName.DOLARESBLUE, 83.50)
        pesos.verCotizaciones()
        pesos.agregarCotizacion(UnidadName.DOLARES, 86.372)
        pesos.verCotizaciones()
        val resultPesos = ConversorGen.convertGen(dolaresBlue, UnidadName.PESOS)
        assertEquals(2276500.00, resultPesos)
        val resultPesosO = ConversorGen.convertGen(dolares, UnidadName.PESOS)
        assertEquals(1783790.00, resultPesosO)
    }
}