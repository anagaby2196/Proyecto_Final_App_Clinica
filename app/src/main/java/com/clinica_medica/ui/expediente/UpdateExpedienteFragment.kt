package com.clinica_medica.ui.expediente

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentUpdateExpedienteBinding
import com.clinica_medica.model.Expediente
import com.clinica_medica.viewmodel.ExpedienteViewModel

class UpdateExpedienteFragment : Fragment() {

    private val args by navArgs<UpdateExpedienteFragmentArgs>()

    private lateinit var expedienteViewModel: ExpedienteViewModel
    private var _binding: FragmentUpdateExpedienteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        expedienteViewModel = ViewModelProvider(this)[ExpedienteViewModel::class.java]
        _binding = FragmentUpdateExpedienteBinding.inflate(inflater, container, false)

        binding.etNombrePaciente.setText(args.expediente.nombrePaciente)
        binding.etPadecimiento.setText(args.expediente.padecimiento)
        binding.etDia.setText(args.expediente.dia)
        binding.etFecha.setText(args.expediente.fecha)
        binding.etHora.setText(args.expediente.hora)
        binding.etNombreDoctor.setText(args.expediente.nombreDoctor)
        binding.etMedicamentos.setText(args.expediente.medicamentos)
        binding.etCuidados.setText(args.expediente.cuidados)

        binding.btActualizarDatosExpediente.setOnClickListener { updateExpediente() }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateExpediente() {
        val nombrePaciente = binding.etNombrePaciente.text.toString()
        val dia = binding.etDia.text.toString()
        val padecimiento = binding.etPadecimiento.text.toString()
        val fecha = binding.etFecha.text.toString()
        val hora = binding.etHora.text.toString()
        val nombreDoctor = binding.etNombreDoctor.text.toString()
        val medicamentos = binding.etMedicamentos.text.toString()
        val cuidados = binding.etCuidados.text.toString()

        if (nombrePaciente.isNotEmpty()) {
            val expediente = Expediente(args.expediente.id,nombrePaciente, padecimiento, dia, fecha, hora, nombreDoctor, medicamentos, cuidados)
            expedienteViewModel.updateExpediente(expediente)
            Toast.makeText(requireContext(), getString(R.string.expediente_updated), Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_updateExpedienteFragment_to_nav_expediente)
        } else {
            Toast.makeText(requireContext(), getString(R.string.fail), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteExpediente()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteExpediente() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete_expediente)
        consulta.setMessage(getString(R.string.seguro_borrar_expediente) + "${args.expediente.nombrePaciente}?")

        consulta.setPositiveButton(getString(R.string.si)) { _, _ ->
            expedienteViewModel.deleteExpediente(args.expediente)
            findNavController().navigate(R.id.action_updateExpedienteFragment_to_nav_expediente)
        }
        consulta.setNegativeButton(getString(R.string.no)) { _, _ -> }

        consulta.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}