package com.clinica_medica.ui.promocion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.clinica_medica.databinding.FragmentAddPromocionBinding
import com.clinica_medica.databinding.FragmentAddServicioBinding
import com.clinica_medica.databinding.FragmentPromocionBinding
import com.clinica_medica.viewmodel.PromocionViewModel
import com.clinica_medica.viewmodel.ServicioViewModel

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

//        binding.btAddPromocion.setOnClickListener { addPromocion() }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}