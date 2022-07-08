package com.clinica_medica.ui.promocion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clinica_medica.databinding.FragmentPromocionBinding
import com.clinica_medica.viewmodel.PromocionViewModel

class PromocionFragment : Fragment() {

    private var _binding: FragmentPromocionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val promocionViewModel =
            ViewModelProvider(this).get(PromocionViewModel::class.java)

        _binding = FragmentPromocionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        promocionViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}