package com.clinica_medica.ui.cita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clinica_medica.R
import com.clinica_medica.adapter.CitaAdapter
import com.clinica_medica.databinding.FragmentCitaBinding
import com.clinica_medica.viewmodel.CitaViewModel

class CitaFragment : Fragment() {

    private lateinit var citaViewModel: CitaViewModel
    private var _binding: FragmentCitaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        citaViewModel = ViewModelProvider(this)[CitaViewModel::class.java]
        _binding = FragmentCitaBinding.inflate(inflater, container, false)

        binding.ibAddCita.setOnClickListener{
            findNavController().navigate(R.id.action_nav_cita_to_addCitaFragment)
        }

        //Activar el reciclador - RecyclerView
        val citaAdapter = CitaAdapter()
        val recicladorCita = binding.recicladorCita

        recicladorCita.adapter = citaAdapter
        recicladorCita.layoutManager = LinearLayoutManager(requireContext())

        citaViewModel = ViewModelProvider(this)[CitaViewModel::class.java]

        citaViewModel.getAllData.observe(viewLifecycleOwner) {
                cita -> citaAdapter.setData(cita)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}