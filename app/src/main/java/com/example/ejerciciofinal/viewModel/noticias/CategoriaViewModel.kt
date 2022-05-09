package com.example.ejerciciofinal.viewModel.noticias

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciofinal.repository.interactor.noticias.NoticiaCategoriasInteractor
import com.example.ejerciciofinal.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriaViewModel : ViewModel(){

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiaCategoriasInteractor()

    fun onBtnMostrarCategoria(categoria: String){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerNoticiasDeporte(categoria))
        }
    }


}
