package org.example

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class UsuarioRedSocial (val nombreApellido: String, val nombreUsuario: String, var email: String, val fechaNacimiento: LocalDate, val seguidos: MutableList<UsuarioRedSocial>, val seguidores: MutableList<UsuarioRedSocial>){
    fun comienzaASeguir(user: UsuarioRedSocial) {
        this.seguidos.add(user)
        user.seguidores.add(this)
    }

    fun obtenerNombre() : String{
        var nombre: String = nombreApellido
        var partes = nombre.split(' ')
        return partes[0]
    }

    fun chequearGmail(): Boolean {
    /*    var emailCh: String = email
        var chEval: Char = '@'
        while (emailCh.first() != chEval) {
            emailCh = emailCh.drop(0)
        }
        return (emailCh.substring(1,6) == "gmail")*/
        return email.contains("@gmail")
    }

    fun edad(): Int {
        return fechaNacimiento.until(LocalDate.now()).years
    }

    fun follow2follow(): List<UsuarioRedSocial> {
        return seguidores.filter { it.seguidores.contains(this)}
    }
}
