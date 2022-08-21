package com.clinica_medica.ui.expediente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentAddExpedienteBinding
import com.clinica_medica.model.Expediente
import com.clinica_medica.viewmodel.ExpedienteViewModel

class AddExpedienteFragment : Fragment() {

    private lateinit var expedienteViewModel: ExpedienteViewModel
    private var _binding: FragmentAddExpedienteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        expedienteViewModel = ViewModelProvider(this)[ExpedienteViewModel::class.java]
        _binding = FragmentAddExpedienteBinding.inflate(inflater, container, false)

        binding.btAgregarDatosExpediente.setOnClickListener { addDatosExpediente() }

        return binding.root
    }

    private fun addDatosExpediente() {
        val nombrePaciente = binding.etNombrePaciente.text.toString()
        val padecimiento = binding.etPadecimiento.text.toString()
        val dia = binding.etDia.text.toString()
        val fecha = binding.etFecha.text.toString()
        val hora = binding.etHora.text.toString()
        val nombreDoctor = binding.etNombreDoctor.text.toString()
        val medicamentos = binding.etMedicamentos.text.toString()
        val cuidados = binding.etCuidados.text.toString()


        if (nombrePaciente.isNotEmpty()) {
            val expediente = Expediente(0, nombrePaciente, padecimiento, dia, fecha, hora, nombreDoctor, medicamentos, cuidados)
            expedienteViewModel.addDatosExpediente(expediente)
            Toast.makeText(requireContext(), getString(R.string.expediente_added), Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_addExpedienteFragment_to_nav_expediente)
        } else {
            Toast.makeText(requireContext(), getString(R.string.no_data_expediente), Toast.LENGTH_SHORT)
                .show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}