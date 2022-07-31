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

//    private lateinit var perfilViewModel: PerfilViewModel
//    private var _binding: FragmentAddPerfilBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        perfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
//        _binding = FragmentAddPerfilBinding.inflate(inflater, container, false)
//
//        binding.btAddPerfil.setOnClickListener { addPerfil() }
//
//        return binding.root
//    }
//
//    private fun addPerfil() {
//        val nombreUsuario=binding.tvNombre.text.toString()
//        val fechaNacimiento=binding.tvFechaNacimiento.text.toString()
//        val direccion=binding.tvDireccion.text.toString()
//        val peso=binding.tvPeso.text.toString()
//        val estatura=binding.tvEstatura.text.toString()
//        val telefono=binding.tvTelefono.text.toString()
//        val correoElectronico=binding.tvCorreoElectronico.text.toString()
//
//        if(nombreUsuario.isNotEmpty()) {
//            val perfil = Perfil(0,nombreUsuario,fechaNacimiento.toInt(),direccion,peso.toDouble(),estatura.toDouble(),telefono.toInt(),correoElectronico,"")
//            perfilViewModel.addPerfil(perfil)
//            Toast.makeText(requireContext(),getString(R.string.perfilAdded), Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_addPerfilFragment_to_nav_perfil)
//        } else {
//            Toast.makeText(requireContext(),getString(R.string.noDataPerfil), Toast.LENGTH_SHORT).show()
//
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}