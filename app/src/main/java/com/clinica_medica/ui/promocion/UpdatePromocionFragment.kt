package com.clinica_medica.ui.promocion

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentUpdatePromocionBinding
import com.clinica_medica.model.Promocion
import com.clinica_medica.viewmodel.PromocionViewModel

class UpdatePromocionFragment : Fragment() {

    private val args by navArgs<UpdatePromocionFragmentArgs>()

    private lateinit var promocionViewModel: PromocionViewModel
    private var _binding: FragmentUpdatePromocionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        promocionViewModel = ViewModelProvider(this)[PromocionViewModel::class.java]
        _binding = FragmentUpdatePromocionBinding.inflate(inflater, container, false)

        binding.etNombrePromocion.setText(args.promocion.nombrePromocion)
        binding.etDescripcionPromocion.setText(args.promocion.descripcion)
        binding.etDescuento.setText(args.promocion.descuento.toString())

        binding.btActualizarPromocion.setOnClickListener { updatePromocion() }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updatePromocion() {
        val nombrePromocion=binding.etNombrePromocion.text.toString()
        val descripcionPromocion=binding.etDescripcionPromocion.text.toString()
        val descuento=binding.etDescuento.text.toString()

        if(nombrePromocion.isNotEmpty()) {
            val promocion = Promocion(args.promocion.id,nombrePromocion,descripcionPromocion,descuento.toInt())
            promocionViewModel.updatePromocion(promocion)
            Toast.makeText(requireContext(),getString(R.string.promocion_updated), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updatePromocionFragment_to_nav_promocion)
        } else {
            Toast.makeText(requireContext(),getString(R.string.fail), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete) {
            deletePromocion()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePromocion() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete_promocion)
        consulta.setMessage(getString(R.string.seguro_borrar)+"${args.promocion.nombrePromocion}?")

        consulta.setPositiveButton(getString(R.string.si)) {_,_ ->
            promocionViewModel.deletePromocion(args.promocion)
            findNavController().navigate(R.id.action_updatePromocionFragment_to_nav_promocion)
        }
        consulta.setNegativeButton(getString(R.string.no)) {_,_ ->}

        consulta.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}