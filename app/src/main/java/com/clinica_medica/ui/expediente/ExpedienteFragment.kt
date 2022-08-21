package com.clinica_medica.ui.expediente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clinica_medica.R
import com.clinica_medica.adapter.ExpedienteAdapter
import com.clinica_medica.databinding.FragmentExpedienteBinding
import com.clinica_medica.viewmodel.ExpedienteViewModel

class ExpedienteFragment : Fragment() {

    private lateinit var expedienteViewModel: ExpedienteViewModel
    private var _binding: FragmentExpedienteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        expedienteViewModel = ViewModelProvider(this)[ExpedienteViewModel::class.java]
        _binding = FragmentExpedienteBinding.inflate(inflater, container, false)

        binding.ibAddExpediente.setOnClickListener{
            findNavController().navigate(R.id.action_nav_expediente_to_addExpedienteFragment)
        }

        //Activar el reciclador - RecyclerView
        val expedienteAdapter = ExpedienteAdapter()
        val recicladorExpediente = binding.recicladorExpediente

        recicladorExpediente.adapter = expedienteAdapter
        recicladorExpediente.layoutManager = LinearLayoutManager(requireContext())

        expedienteViewModel = ViewModelProvider(this)[ExpedienteViewModel::class.java]

        expedienteViewModel.getAllData.observe(viewLifecycleOwner) {
                expediente -> expedienteAdapter.setData(expediente)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}