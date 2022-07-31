package com.clinica_medica.ui.perfil

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentUpdatePerfilBinding
import com.clinica_medica.model.Perfil
import com.clinica_medica.viewmodel.PerfilViewModel


class UpdatePerfilFragment : Fragment() {

//    private val args by navArgs<UpdatePerfilFragmentArgs>()
//
//    private lateinit var perfilViewModel: PerfilViewModel
//    private var _binding: FragmentUpdatePerfilBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        perfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
//        _binding = FragmentUpdatePerfilBinding.inflate(inflater, container, false)
//
//        binding.btActualizarPerfil.setOnClickListener { updatePerfil() }
//
//        setHasOptionsMenu(true)
//
//        return binding.root
//    }
//
//    private fun updatePerfil() {
//
//        val fechaNacimiento = binding.tvFechaNacimiento.text.toString()
//        val direccion = binding.tvDireccion.text.toString()
//        val peso = binding.tvPeso.text.toString()
//        val estatura = binding.tvEstatura.text.toString()
//        val telefono = binding.tvTelefono.text.toString()
//        val correoElectronico = binding.tvCorreoElectronico.text.toString()
//
//        val perfil = Perfil(
//            args.perfil.id,
//            "",
//            fechaNacimiento.toInt(),
//            direccion,
//            peso.toDouble(),
//            estatura.toDouble(),
//            telefono.toInt(),
//            correoElectronico,
//            ""
//        )
//        perfilViewModel.updatePerfil(perfil)
//        Toast.makeText(requireContext(), getString(R.string.perfilUpdated), Toast.LENGTH_SHORT)
//            .show()
//        findNavController().navigate(R.id.action_updatePerfilFragment_to_nav_perfil)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}