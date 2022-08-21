package com.clinica_medica.ui.cita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentAddCitaBinding
import com.clinica_medica.model.Cita
import com.clinica_medica.viewmodel.CitaViewModel

class AddCitaFragment : Fragment() {

    private lateinit var citaViewModel: CitaViewModel
    private var _binding: FragmentAddCitaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        citaViewModel = ViewModelProvider(this)[CitaViewModel::class.java]
        _binding = FragmentAddCitaBinding.inflate(inflater, container, false)

        binding.btAgregarDatosCita.setOnClickListener { addDatosCita() }

        return binding.root
    }

    private fun addDatosCita() {
        val nombrePaciente = binding.etNombrePaciente.text.toString()
        val padecimiento = binding.etPadecimiento.text.toString()
        val dia = binding.etDia.text.toString()
        val fecha = binding.etFecha.text.toString()
        val hora = binding.etHora.text.toString()
        val nombreDoctor = binding.etNombreDoctor.text.toString()

        if (nombrePaciente.isNotEmpty()) {
            val cita = Cita(0, nombrePaciente,padecimiento,dia,fecha,hora,nombreDoctor)
            citaViewModel.addDatosCita(cita)
            Toast.makeText(requireContext(), getString(R.string.cita_added), Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_addCitaFragment_to_nav_cita)
        } else {
            Toast.makeText(requireContext(), getString(R.string.no_data_cita), Toast.LENGTH_SHORT)
                .show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}