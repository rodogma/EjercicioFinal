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
import com.example.ejerciciofinal.databinding.FragmentFragDeportesBinding
import com.example.ejerciciofinal.recyclerview.Adaptador
import com.example.ejerciciofinal.viewModel.noticias.CategoriaViewModel


class FragDeportes : Fragment() {
    lateinit var binding : FragmentFragDeportesBinding
    lateinit var  categoriaViewModel: CategoriaViewModel

    private lateinit var  myRecyclerWiewDeportes : RecyclerView
    private lateinit var  adaptador: Adaptador



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragDeportesBinding.inflate(layoutInflater)
        categoriaViewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)
        observar()

        myRecyclerWiewDeportes = binding.myRecyclerViewDeportes
        myRecyclerWiewDeportes.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        categoriaViewModel.onBtnMostrarCategoria("sports")

        binding.btnMostrarDeporte.setOnClickListener {
            binding.progressBarDeportes.visibility = View.VISIBLE
            categoriaViewModel.onBtnMostrarCategoria("sports")
        }

        return  binding.root
    }

   private fun observar(){
       categoriaViewModel.noticias.observe(viewLifecycleOwner, Observer {
           binding.progressBarDeportes.visibility = View.GONE
           adaptador = Adaptador(requireContext().applicationContext,it.data)
           myRecyclerWiewDeportes.adapter = adaptador
       })
   }
}