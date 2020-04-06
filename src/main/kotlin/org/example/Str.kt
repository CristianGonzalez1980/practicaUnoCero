package org.example

object ManejoStr {

    fun deReversa(string: String) : String {
        return string.reversed()
    }

    fun esCapicua(string: String) : Boolean {
        var eval: String = string
        var resul: Boolean
        while (eval.length > 1 && eval.first() == eval.last()) {
           eval = eval.drop(1).dropLast(1)
           // eval.subSequence(1,eval.length-1)
        }
        resul = eval.length <= 1
        return resul
    }

    fun vocales(string: String): Int {
        var eval: String = string
        var voc: List<Char> = listOf('a','e','i','o','u','A','E','I','O','U')
        return eval.count {it in voc}
    }

    fun palabras(string: String): Int {
        var eval: String = string
        return eval.count {it in " "} +1
    }

    fun parrafos(string: String): Int {
        var eval: String = string
        return eval.count {it in "\n"} +1

    }

}