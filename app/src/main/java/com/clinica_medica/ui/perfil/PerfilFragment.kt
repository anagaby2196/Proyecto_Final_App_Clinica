package com.clinica_medica.ui.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clinica_medica.R
import com.clinica_medica.databinding.FragmentPerfilBinding
import com.clinica_medica.viewmodel.PerfilViewModel

class PerfilFragment : Fragment() {

    private lateinit var perfilViewModel: PerfilViewModel
    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        perfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
       perfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}