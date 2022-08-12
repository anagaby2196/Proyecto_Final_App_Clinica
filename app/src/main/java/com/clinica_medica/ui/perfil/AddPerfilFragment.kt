package com.clinica_medica.ui.perfil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentAddPerfilBinding
import com.clinica_medica.model.Perfil
import com.clinica_medica.viewmodel.PerfilViewModel

class AddPerfilFragment : Fragment() {

    private lateinit var perfilViewModel: PerfilViewModel
    private var _binding: FragmentAddPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        perfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
        _binding = FragmentAddPerfilBinding.inflate(inflater, container, false)

        binding.btAgregarDatosPerfil.setOnClickListener { addDatosPerfil() }

        return binding.root
    }

    private fun addDatosPerfil() {
        val nombreUsuario=binding.etNombreUsuario.text.toString()
        val fechaNacimiento=binding.etFechaNacimiento.text.toString()
        val direccion=binding.etDireccion.text.toString()
        val peso=binding.etPeso.text.toString()
        val estatura=binding.etEstatura.text.toString()
        val telefono=binding.etNumeroTelefonico.text.toString()
        val correoElectronico=binding.etCorreoElectronico.text.toString()
        val historialMedico=binding.etHistorialMedico.text.toString()
        val fechaCita=binding.etfechaCita.text.toString()

        if(nombreUsuario.isNotEmpty()) {
            val perfil = Perfil(0,nombreUsuario,fechaNacimiento,direccion,peso.toDouble(),estatura.toDouble(),telefono.toInt(),correoElectronico,historialMedico,fechaCita)
            perfilViewModel.addDatosPerfil(perfil)
            Toast.makeText(requireContext(),getString(R.string.perfil_added), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addPerfilFragment_to_nav_perfil)
        } else {
            Toast.makeText(requireContext(),getString(R.string.no_data_perfil), Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}