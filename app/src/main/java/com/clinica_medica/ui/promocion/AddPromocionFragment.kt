package com.clinica_medica.ui.promocion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentAddPromocionBinding
import com.clinica_medica.model.Promocion
import com.clinica_medica.viewmodel.PromocionViewModel

class AddPromocionFragment : Fragment() {

    private lateinit var promocionViewModel: PromocionViewModel
    private var _binding: FragmentAddPromocionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        promocionViewModel = ViewModelProvider(this)[PromocionViewModel::class.java]
        _binding = FragmentAddPromocionBinding.inflate(inflater, container, false)

        binding.btAddPromocion.setOnClickListener { addPromocion() }

        return binding.root
    }

    private fun addPromocion() {
        val nombrePromocion=binding.etNombrePromocion.text.toString()
        val descripcionPromocion=binding.etDescripcionPromocion.text.toString()
        val descuento=binding.etDescuento.text.toString()

        if(nombrePromocion.isNotEmpty()) {
            val promocion = Promocion(0,nombrePromocion,descripcionPromocion,descuento.toInt())
            promocionViewModel.addPromocion(promocion)
            Toast.makeText(requireContext(),getString(R.string.promocion_added), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addPromocionFragment_to_nav_promocion)
        } else {
            Toast.makeText(requireContext(),getString(R.string.no_data_promocion), Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}