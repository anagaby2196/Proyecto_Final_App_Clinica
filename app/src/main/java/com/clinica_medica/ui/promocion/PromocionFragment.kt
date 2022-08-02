package com.clinica_medica.ui.promocion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clinica_medica.R
import com.clinica_medica.adapter.PromocionAdapter
import com.clinica_medica.databinding.FragmentPromocionBinding
import com.clinica_medica.viewmodel.PromocionViewModel

class PromocionFragment : Fragment() {

    private lateinit var promocionViewModel: PromocionViewModel
    private var _binding: FragmentPromocionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        promocionViewModel = ViewModelProvider(this)[PromocionViewModel::class.java]
        _binding = FragmentPromocionBinding.inflate(inflater, container, false)

        binding.addPromocionButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_promocion_to_addPromocionFragment)
        }

        //Activar el reciclador - RecyclerView
        val promocionAdapter = PromocionAdapter()
        val recicladorPromocion = binding.recicladorPromocion

        recicladorPromocion.adapter = promocionAdapter
        recicladorPromocion.layoutManager = LinearLayoutManager(requireContext())

        promocionViewModel = ViewModelProvider(this)[PromocionViewModel::class.java]

        promocionViewModel.getAllData.observe(viewLifecycleOwner) {
                promociones -> promocionAdapter.setData(promociones)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}