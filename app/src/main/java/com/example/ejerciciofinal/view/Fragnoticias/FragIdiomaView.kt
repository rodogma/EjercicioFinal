package com.example.ejerciciofinal.view.Fragnoticias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ejerciciofinal.R
import com.example.ejerciciofinal.databinding.FragmentFragIdiomaViewBinding


class FragIdiomaView : Fragment() {
    lateinit var  binding : FragmentFragIdiomaViewBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragIdiomaViewBinding.inflate(layoutInflater)

        binding.btnIdioma.setOnClickListener {
            Toast.makeText(requireContext().applicationContext,escogerIdioma(),Toast.LENGTH_SHORT).show()
            var bundle = Bundle()
            bundle.putString("idioma",escogerIdioma())

            val fragment = FragHomeNoticia()
            fragment.arguments = bundle
            val fm: FragmentManager = requireActivity().supportFragmentManager
            val ft: FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.myFrame,fragment)
            ft.addToBackStack(null)
            ft.commit()
        }
        return binding.root




    }
    fun escogerIdioma(): String{
    var idioma = ""
    if(binding.checkSpanish.isChecked){
        idioma = "es"
    }
    if (binding.checkIngles.isChecked){
        idioma = "en"
    }
    if (binding.checkRuso.isChecked){
        idioma = "ru"
    }
    if (binding.checkIt.isChecked){
        idioma = "it"
    }
    return idioma

}



}