package com.clinica_medica.ui.servicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentAddServicioBinding
import com.clinica_medica.viewmodel.ServicioViewModel

class AddServicioFragment : Fragment() {

    private lateinit var servicioViewModel: ServicioViewModel
    private var _binding: FragmentAddServicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        servicioViewModel = ViewModelProvider(this)[ServicioViewModel::class.java]
        _binding = FragmentAddServicioBinding.inflate(inflater, container, false)

//        binding.btAddServicio.setOnClickListener { addServicio() }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}