package com.example.ejerciciofinal.viewModel.usuarios

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciofinal.repository.interactor.usuario.RegistroUsuarioInteractor
import com.example.ejerciciofinal.repository.retrofit.Usuario
import com.example.ejerciciofinal.repository.retrofit.UsuarioItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistroViewModel : ViewModel() {

    var usuarios : MutableLiveData<Int> = MutableLiveData()
    private val registroInteractor = RegistroUsuarioInteractor()

    fun onBtnValidarUsuarioRegistro(usuarioItem: UsuarioItem){
        CoroutineScope(Dispatchers.IO).launch {

            var x: Usuario? = registroInteractor.validarRegistro(usuarioItem.usuario)

            if(x == null){
                //var cant = registroInteractor.cantidadRegistros()
                val aux: Int =
                    withContext(Dispatchers.Default) {
                        registroInteractor.cantidadRegistros()
                    }

                registroInteractor.registrarUsuario(aux, usuarioItem)
                usuarios.postValue(1)
            }
            else{
                usuarios.postValue(0)
            }
        }
    }
}