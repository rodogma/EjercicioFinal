package com.example.ejerciciofinal.repository.retrofit

class Usuario: ArrayList<UsuarioItem>()

data class UsuarioItem(
    val nombre:String,
    val rut: String,
    val mail: String,
    val usuario: String,
    val pass: String,
)