package com.example.ejerciciofinal.repository.interactor.usuario

import com.example.ejerciciofinal.repository.retrofit.Usuario
import com.example.ejerciciofinal.repository.retrofit.UsuarioItem
import com.example.ejerciciofinal.repository.retrofit.login.RestEngineUsuario
import com.example.ejerciciofinal.repository.retrofit.login.UsuarioAPIService
import retrofit2.Call


class RegistroUsuarioInteractor {

    //CONSEGUIR Q EL METODO RETORNE UN USUARIOITEM
    fun registrarUsuario(x: Int, usuarioItem: UsuarioItem){
        val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<UsuarioItem> = llamada.agregarUsuario(x, usuarioItem)
        val u: UsuarioItem? = resultado.execute().body()

    }

    fun validarRegistro(usuario: String): Usuario?{
        val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuario("bd.json")
        val u: Usuario? = resultado.execute().body()

        for (i in u!!){
            if (i.usuario == usuario){
                return u
            }
        }
        return null
    }

    fun cantidadRegistros():Int {
        val llamada: UsuarioAPIService =
            RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuario("bd.json")
        val u: Usuario? = resultado.execute().body()
        return u!!.size
    }


}