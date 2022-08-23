package com.clinica_medica.ui.perfil

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentUpdatePerfilBinding
import com.clinica_medica.model.Perfil
import com.clinica_medica.viewmodel.PerfilViewModel

class UpdatePerfilFragment : Fragment() {

    private val args by navArgs<UpdatePerfilFragmentArgs>()

    private lateinit var perfilViewModel: PerfilViewModel
    private var _binding: FragmentUpdatePerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        perfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
        _binding = FragmentUpdatePerfilBinding.inflate(inflater, container, false)

        binding.etNombreUsuario.setText(args.perfil.nombreUsuario)
        binding.etFechaNacimiento.setText(args.perfil.fechaNacimiento)
        binding.etDireccion.setText(args.perfil.direccion)
        binding.etPeso.setText(args.perfil.peso.toString())
        binding.etEstatura.setText(args.perfil.estatura.toString())
        binding.etNumeroTelefonico.setText(args.perfil.numeroTelefono.toString())
        binding.etCorreoElectronico.setText(args.perfil.correoElectronico)
        binding.etHistorialMedico.setText(args.perfil.historial)
        binding.etfechaCita.setText(args.perfil.fechaCita)

        binding.btActualizarDatosPerfl.setOnClickListener { updatePerfil() }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updatePerfil() {
        val nombreUsuario=binding.etNombreUsuario.text.toString()
        val fechaNacimiento=binding.etFechaNacimiento.text.toString()
        val direccion=binding.etDireccion.text.toString()
        val peso=binding.etPeso.text.toString()
        val estatura=binding.etEstatura.text.toString()
        val numeroTelefonico=binding.etNumeroTelefonico.text.toString()
        val correoElectronico=binding.etCorreoElectronico.text.toString()
        val historialMedico=binding.etHistorialMedico.text.toString()
        val fechaCita=binding.etfechaCita.text.toString()


        if(nombreUsuario.isNotEmpty()) {
            val perfil = Perfil(args.perfil.id,nombreUsuario,fechaNacimiento,direccion,peso.toDouble(),estatura.toDouble(), numeroTelefonico.toInt(),correoElectronico
            ,historialMedico,fechaCita)
            perfilViewModel.updatePerfil(perfil)
            Toast.makeText(requireContext(),getString(R.string.perfil_updated), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updatePerfilFragment_to_nav_perfil)
        } else {
            Toast.makeText(requireContext(),getString(R.string.fail), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete) {
            deletePerfil()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePerfil() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete_perfil)
        consulta.setMessage(getString(R.string.seguro_borrar_perfil)+"${args.perfil.nombreUsuario}?")

        consulta.setPositiveButton(getString(R.string.si)) {_,_ ->
            perfilViewModel.deletePerfil(args.perfil)
            findNavController().navigate(R.id.action_updatePerfilFragment_to_nav_perfil)
        }
        consulta.setNegativeButton(getString(R.string.no)) {_,_ ->}

        consulta.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}