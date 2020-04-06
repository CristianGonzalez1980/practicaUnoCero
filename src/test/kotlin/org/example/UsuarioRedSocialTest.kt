package org.example

import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class UsuarioRedSocialTest {
   /*
    Escribir un programa que permita obtener información de un Usuario de una red social. Características de los usuarios:

    Nombre y apellido
    Nombre de usuario
    E-Mail
    Fecha de nacimiento
    Seguidores
    Seguidos

    A partir del diseño se debe poder:

    Obtener la información básica (nombre, usuario, etc).
    Calcular la edad.
    Determinar si el e-mail registrado es de gmail.
    Obtener los seguidores que a la vez son seguidos por ese usuario.
    */

    @Test fun `obetener informacion basica`() {
        val user: UsuarioRedSocial
        user = UsuarioRedSocial("Martin Piroyansky", "martu1999", "martu1999@yahoo.com.ar", LocalDate.of(1999, 8, 8), mutableListOf(), mutableListOf())
        assertEquals("Martin", user.obtenerNombre())
        assertEquals("martu1999", user.nombreUsuario)
        assertEquals("martu1999@yahoo.com.ar", user.email)
    }

    @Test fun `calcular la edad del usuario`() {
        val user: UsuarioRedSocial
        user = UsuarioRedSocial("Martin Piroyansky", "martu1999", "martu1999@yahoo.com.ar", LocalDate.of(1999, 2, 8), mutableListOf(), mutableListOf())
        assertEquals(21, user.edad())
    }

    @Test fun `chequear si el email es de gmail`() {
        val user: UsuarioRedSocial
        user = UsuarioRedSocial("Martin Piroyansky", "martu1999", "martu1999@yahoo.com.ar", LocalDate.of(1999, 8, 8), mutableListOf(), mutableListOf())
        assertEquals(false, user.chequearGmail())
    }

    @Test fun `seguidores a la vez seguidos por el usuario`() {
        val user: UsuarioRedSocial
        val user2: UsuarioRedSocial
        val user3: UsuarioRedSocial
        val user4: UsuarioRedSocial
        user2 = UsuarioRedSocial("Micaela Martinez", "Micaeala80", "mica1980@gmail.com", LocalDate.of(1980,8,8), mutableListOf(), mutableListOf())
        user3 = UsuarioRedSocial("Sebastian Huarpe", "Quemero2020", "huracanCampion@hotmail.com", LocalDate.of(1990, 12, 31), mutableListOf(), mutableListOf())
        user4 = UsuarioRedSocial("Agustin Piroyansky", "agusthebest", "agustinPiro@gmail.com", LocalDate.of(2000, 10, 7), mutableListOf(), mutableListOf())
        user = UsuarioRedSocial("Martin Piroyansky", "martu1999", "martu1999@yahoo.com.ar", LocalDate.of(1999, 8, 8), mutableListOf(), mutableListOf())
        user.comienzaASeguir(user2)
        user.comienzaASeguir(user3)
        user.comienzaASeguir(user4)
        user2.comienzaASeguir(user)
        user3.comienzaASeguir(user2)
       // user3.comienzaASeguir(user)
        user3.comienzaASeguir(user4)
        user4.comienzaASeguir(user3)
        user4.comienzaASeguir(user)
        assertEquals(listOf(user2, /*user3,*/ user4), user.follow2follow())
    }
}