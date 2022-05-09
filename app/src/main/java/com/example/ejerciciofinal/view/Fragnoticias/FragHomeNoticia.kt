package com.example.ejerciciofinal.view.Fragnoticias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciofinal.databinding.FragmentFragHomeNoticiaBinding
import com.example.ejerciciofinal.recyclerview.Adaptador
import com.example.ejerciciofinal.viewModel.noticias.MainViewModel


class FragHomeNoticia : Fragment() {
    lateinit var binding: FragmentFragHomeNoticiaBinding
    lateinit var mainViewModel: MainViewModel
     lateinit var myRecyclerView1: RecyclerView
     lateinit var adaptador: Adaptador
    lateinit var idioma:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragHomeNoticiaBinding.inflate(layoutInflater)

        var bundle: Bundle? = arguments
        if(bundle != null){
            idioma = bundle!!.getString("idioma", "es")
        }
        else{
            idioma = "es"
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observar()
                        myRecyclerView1 = binding.myRecyclerView
                        myRecyclerView1.layoutManager =
                                LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

   mainViewModel.onBtnMostrarNoticias(idioma)

binding.btnMostrarNoticia.setOnClickListener {
    binding.progressBar.visibility = View.VISIBLE
    mainViewModel.onBtnMostrarNoticias(idioma)
}

        binding.btnBuscarNoticia.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.onBtnTraerKeywords(
                binding.textView.text.toString())
        }






        return binding.root
    }

    private fun observar(){
        mainViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            adaptador = Adaptador (requireContext().applicationContext,it.data)
            myRecyclerView1.adapter = adaptador
        } )

    }

}




