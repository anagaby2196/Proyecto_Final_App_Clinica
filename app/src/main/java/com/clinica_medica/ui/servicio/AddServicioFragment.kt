package com.clinica_medica.ui.servicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentAddServicioBinding
import com.clinica_medica.model.Servicio
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

        binding.btAddServicio.setOnClickListener { addServicio() }

        return binding.root
    }

    private fun addServicio() {
        val nombreServicio=binding.etNombreServicio.text.toString()
        val descripcion=binding.etDescripcionServicio.text.toString()
        val costo=binding.etCosto.text.toString()

        if(nombreServicio.isNotEmpty()) {
            val servicio = Servicio(0,nombreServicio,descripcion,costo.toInt(),"")
            servicioViewModel.addServicio(servicio)
            Toast.makeText(requireContext(),getString(R.string.servicio_added), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addServicioFragment_to_nav_servicio)
        } else {
            Toast.makeText(requireContext(),getString(R.string.no_data_servicio), Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}