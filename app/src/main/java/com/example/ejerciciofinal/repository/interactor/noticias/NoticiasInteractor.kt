package com.example.ejerciciofinal.repository.interactor.noticias

import com.example.ejerciciofinal.repository.retrofit.Noticias
import com.example.ejerciciofinal.repository.retrofit.noticias.NoticiasAPIService
import com.example.ejerciciofinal.repository.retrofit.noticias.RestEngine
import retrofit2.Call

class NoticiasInteractor {
    fun traerRespuesta(languages: String): Noticias?{
        val llamada: NoticiasAPIService = RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }

    fun traerKeywords(keyword: String):Noticias?{
        val llamada: NoticiasAPIService = RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.buscarPalabraClave(keyword)
        val p: Noticias? = resultado.execute().body()

        return p
    }
}