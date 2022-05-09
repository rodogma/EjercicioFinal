package com.example.ejerciciofinal.viewModel.noticias

import androidx.lifecycle.MutableLiveData
import  androidx.lifecycle.ViewModel

import com.example.ejerciciofinal.repository.interactor.noticias.NoticiasInteractor
import com.example.ejerciciofinal.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiasInteractor()

    fun onBtnMostrarNoticias(languajes: String) {
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuesta(languajes))
        }
    }


    fun onBtnTraerKeywords(keywords: String){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerKeywords(keywords))
        }
   }



 }