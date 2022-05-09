package com.example.ejerciciofinal.view.usuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejerciciofinal.R
import com.example.ejerciciofinal.databinding.ActivityLoginBinding
import com.example.ejerciciofinal.databinding.ActivityNoticiaViewBinding
import com.example.ejerciciofinal.repository.retrofit.Data
import com.google.gson.Gson

class NoticiaView : AppCompatActivity() {
    lateinit var  binding: ActivityNoticiaViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("data")

        val noticia: Data = Gson().fromJson(texto, Data::class.java)

        binding.myWebView.loadUrl(noticia.url)

        binding.shareBtn.setOnClickListener() {
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Mira esta Noticia: "+ noticia.url)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Compartir Noticia a: "))
        }
    }
}