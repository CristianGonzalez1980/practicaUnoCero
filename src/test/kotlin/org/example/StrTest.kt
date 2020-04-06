package org.example

import org.junit.Test
import kotlin.test.assertEquals

class StrTest {
    /*
    Dado un string, retornarlo al revés. Ej: revert("interfaces") == "secafretni"
    Dada una palabra, determinar si es capicúa. Ej: isPalindrome("interfaces") == false; isPalindrome("neuquen") == true
    Dado un string, retornar la cantidad de vocales que contiene. Ej: vowels("Ácido clorhídrico") == 7
    Dada una oración, retornar la cantidad de palabras que contiene. Ej: words("construcción de interfaces de usuario") == 5
    Dado un texto, retornar la cantidad de párrafos que contiene. Un párrafo comienza luego de un salto de línea.

 */
    @Test fun `retorno un STRING al reves`() {
        var str1: String = "interfaces"
        assertEquals("secafretni", ManejoStr.deReversa(str1))
    }

    @Test fun `verificar si un STRING es palindrome`() {
        var str1: String = "reconocer"
        assertEquals(true, ManejoStr.esCapicua(str1))
    }

    @Test fun `cantidad de vocales en STRING`() {
        var str1: String = "La ciudad de la furia"
        assertEquals(9, ManejoStr.vocales(str1))
    }

    @Test fun `cantidad de palabras en STRING` () {
        var str1: String = "construcción de interfaces de usuario"
        assertEquals(5, ManejoStr.palabras(str1))
    }
    @Test fun `cantidad de parrafos en STRING` () {
        var str1: String = "Esta es la primera linea del parrafo.\n Esta es la segunda.\n Y esta es la tercera"
        assertEquals(3, ManejoStr.parrafos(str1))
    }
}