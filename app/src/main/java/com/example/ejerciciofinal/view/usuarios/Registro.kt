package com.example.ejerciciofinal.view.usuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciofinal.R
import com.example.ejerciciofinal.databinding.ActivityRegistroBinding
import com.example.ejerciciofinal.repository.retrofit.UsuarioItem
import com.example.ejerciciofinal.viewModel.usuarios.RegistroViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Registro : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    lateinit var registroViewModel: RegistroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registroViewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)
        observar()

        binding.btnRegistrarUsuario.setOnClickListener {
            binding.progressBarRegistro.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                var user = UsuarioItem(binding.txtNombre.text.toString(),
                                       binding.txtRut.text.toString(),
                                       binding.txtMail.text.toString(),
                                       binding.txtUsuario.text.toString(),
                                       binding.txtContrasena.text.toString())

                registroViewModel.onBtnValidarUsuarioRegistro(user)



            }
        }

    }

    private fun observar() {
        registroViewModel.usuarios.observe(this, Observer {
            if (registroViewModel.usuarios != null){
                val intent = Intent(applicationContext, Login::class.java)
                startActivity(intent)
                Toast.makeText(applicationContext, "Usuario registrado correctamente!",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext, "Usuario ya registrado", Toast.LENGTH_SHORT).show()
            }
        })
    }
}