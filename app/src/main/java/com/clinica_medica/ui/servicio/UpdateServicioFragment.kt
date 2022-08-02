package com.clinica_medica.ui.servicio

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentUpdateServicioBinding
import com.clinica_medica.model.Servicio
import com.clinica_medica.viewmodel.ServicioViewModel

class UpdateServicioFragment : Fragment() {

    private val args by navArgs<UpdateServicioFragmentArgs>()

    private lateinit var servicioViewModel: ServicioViewModel
    private var _binding: FragmentUpdateServicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        servicioViewModel = ViewModelProvider(this)[ServicioViewModel::class.java]
        _binding = FragmentUpdateServicioBinding.inflate(inflater, container, false)

        binding.etNombreServicio.setText(args.servicio.nombreServicio)
        binding.etDescripcionServicio.setText(args.servicio.descripcion)
        binding.etCosto.setText(args.servicio.costo.toString())

        binding.btActualizarServicio.setOnClickListener { updateServicio() }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateServicio() {
        val nombreServicio=binding.etNombreServicio.text.toString()
        val descripcion=binding.etDescripcionServicio.text.toString()
        val costo=binding.etCosto.text.toString()

        if(nombreServicio.isNotEmpty()) {
            val servicio = Servicio(args.servicio.id,nombreServicio,descripcion, costo.toInt(),"")
            servicioViewModel.updateServicio(servicio)
            Toast.makeText(requireContext(),getString(R.string.servicio_updated), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateServicioFragment_to_nav_servicio)
        } else {
            Toast.makeText(requireContext(),getString(R.string.fail), Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete) {
            deleteServicios()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteServicios() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete)
        consulta.setMessage(getString(R.string.seguro_borrar)+"${args.servicio.nombreServicio}?")

        consulta.setPositiveButton(getString(R.string.si)) {_,_ ->
            servicioViewModel.deleteServicio(args.servicio)
            findNavController().navigate(R.id.action_updateServicioFragment_to_nav_servicio)
        }
        consulta.setNegativeButton(getString(R.string.no)) {_,_ ->}

        consulta.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}