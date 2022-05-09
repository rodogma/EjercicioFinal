package com.example.ejerciciofinal.view.usuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciofinal.R
import com.example.ejerciciofinal.databinding.ActivityLoginBinding
import com.example.ejerciciofinal.view.noticias.MainActivity
import com.example.ejerciciofinal.viewModel.usuarios.LoginViewModel

class Login : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    //ViewModel
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewModel
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observar()

        binding.btnRegistrarse.setOnClickListener {
            val intent = Intent(applicationContext, Registro::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {


            var usuario = binding.txtUsuario.text.toString()
            var pass = binding.txtContrasena.text.toString()

            loginViewModel.onBtnValidarUsuario(usuario, pass)
        }
    }

private fun observar() {
    loginViewModel.usuarios.observe(this, Observer {
        binding.progressBar.visibility = View.GONE
        if (it != null){

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }else{


            Toast.makeText(applicationContext, "Usuario no registrado", Toast.LENGTH_SHORT).show()

        }
    })


}
}
