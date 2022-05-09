package com.example.ejerciciofinal.repository.interactor.usuario

import com.example.ejerciciofinal.repository.retrofit.Usuario
import com.example.ejerciciofinal.repository.retrofit.login.RestEngineUsuario
import com.example.ejerciciofinal.repository.retrofit.login.UsuarioAPIService
import retrofit2.Call

class LoginUsuarioInteractor {

    fun validarUsuario(usuario: String, contrasena: String): Usuario? {

        val llamada : UsuarioAPIService =  RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado : Call<Usuario> = llamada.obtenerUsuario("bd.json")
        val u: Usuario? = resultado.execute().body()
        //var aux: Int = 0
        for (i in u!!){
            if (i.usuario == usuario && i.pass == contrasena){
                return u
               // aux = 1
            //} else {
             //   aux = 0
            }
        }
        return null
      //return  aux
    }
}