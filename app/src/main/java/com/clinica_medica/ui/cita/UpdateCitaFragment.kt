package com.clinica_medica.ui.cita

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentUpdateCitaBinding
import com.clinica_medica.model.Cita
import com.clinica_medica.viewmodel.CitaViewModel

class UpdateCitaFragment : Fragment() {

    private val args by navArgs<UpdateCitaFragmentArgs>()

    private lateinit var citaViewModel: CitaViewModel
    private var _binding: FragmentUpdateCitaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        citaViewModel = ViewModelProvider(this)[CitaViewModel::class.java]
        _binding = FragmentUpdateCitaBinding.inflate(inflater, container, false)

        binding.etNombrePaciente.setText(args.cita.nombrePaciente)
        binding.etPadecimiento.setText(args.cita.padecimiento)
        binding.etDia.setText(args.cita.dia)
        binding.etFecha.setText(args.cita.fecha)
        binding.etHora.setText(args.cita.hora)
        binding.etNombreDoctor.setText(args.cita.nombreDoctor)

        binding.btActualizarDatosCita.setOnClickListener { updateCita() }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateCita() {
        val nombrePaciente = binding.etNombrePaciente.text.toString()
        val padecimiento = binding.etPadecimiento.text.toString()
        val dia = binding.etDia.text.toString()
        val fecha = binding.etFecha.text.toString()
        val hora = binding.etHora.text.toString()
        val nombreDoctor = binding.etNombreDoctor.text.toString()

        if (nombrePaciente.isNotEmpty()) {
            val cita = Cita(args.cita.id, nombrePaciente,padecimiento,dia,fecha, hora,nombreDoctor)
            citaViewModel.updateCita(cita)
            Toast.makeText(requireContext(), getString(R.string.cita_updated), Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_updateCitaFragment_to_nav_cita)
        } else {
            Toast.makeText(requireContext(), getString(R.string.fail), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteCita()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteCita() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete_cita)
        consulta.setMessage(getString(R.string.seguro_borrar_cita) + "${args.cita.nombrePaciente}?")

        consulta.setPositiveButton(getString(R.string.si)) { _, _ ->
            citaViewModel.deleteCita(args.cita)
            findNavController().navigate(R.id.action_updateCitaFragment_to_nav_cita)
        }
        consulta.setNegativeButton(getString(R.string.no)) { _, _ -> }

        consulta.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}