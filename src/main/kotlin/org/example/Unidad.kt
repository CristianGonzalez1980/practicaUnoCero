package org.example

class Unidad (val name: UnidadName, val monto: Double, private val cotizaciones: MutableMap<UnidadName, Double>) {

    fun agregarCotizacion(nuevaUnidad: UnidadName, conversion: Double) {
        cotizaciones[nuevaUnidad] = conversion
    }
    fun verCotizaciones() = println(cotizaciones)

    fun buscarCotizacion(unidad: UnidadName) : Double {
        return cotizaciones[unidad]!!
    }
}
