package org.example

import java.lang.Exception

object ConversorM {
    private const val uniti: Double = 1.60934
    fun convert(milla: Double) : Double = milla * uniti
}

object ConversorK {
    private const val uniti: Double = 0.621371
    fun convert(kms: Double) : Double = kms * uniti
}

object ConversorBi {
    fun convertBi(unidad: Unidad): Double {
        return if (unidad.name == UnidadName.MILLAS) ConversorM.convert(unidad.monto) else ConversorK.convert(unidad.monto)
        //if (unidad.name == "UnidadName.KILOMETROS") ConversorK.convert(unidad.monto) else throw Exception(message = "Nombre de unidad irreconocible")
    }
}

object ConversorGen {
    fun convertGen(unidad: Unidad, unidad2: UnidadName) : Double {
        return (unidad.monto * unidad.buscarCotizacion(unidad2))
    }

}