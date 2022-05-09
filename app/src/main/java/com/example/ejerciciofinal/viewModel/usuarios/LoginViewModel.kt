package com.example.ejerciciofinal.viewModel.usuarios

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciofinal.repository.interactor.usuario.LoginUsuarioInteractor
import com.example.ejerciciofinal.repository.retrofit.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var usuarios : MutableLiveData<Usuario> = MutableLiveData()
    private val usuarioInteractor = LoginUsuarioInteractor()

    fun onBtnValidarUsuario(usuario: String, pass: String){
        CoroutineScope(Dispatchers.IO).launch {
            usuarios.postValue( usuarioInteractor.validarUsuario(usuario, pass))
        }
    }
}