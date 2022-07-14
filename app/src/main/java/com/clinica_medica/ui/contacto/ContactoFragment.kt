package com.clinica_medica.ui.contacto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentContactoBinding
import com.clinica_medica.viewmodel.ContactoViewModel


class ContactoFragment : Fragment() {

    private lateinit var contactoViewModel: ContactoViewModel
    private var _binding: FragmentContactoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        contactoViewModel = ViewModelProvider(this)[ContactoViewModel::class.java]
        _binding = FragmentContactoBinding.inflate(inflater, container, false)



        contactoViewModel = ViewModelProvider(this)[ContactoViewModel::class.java]


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}