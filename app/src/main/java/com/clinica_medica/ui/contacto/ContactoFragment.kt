package com.clinica_medica.ui.contacto

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        binding.ibCorreo.setOnClickListener { (escribirCorreo())}
        binding.btPhone.setOnClickListener { (llamarLugar())}
//        binding.ibWhatsapp.setOnClickListener { (enviarWhatsapp())}
        binding.ibFacebook.setOnClickListener { (visitarFacebook())}
        binding.ibInstagram.setOnClickListener { (visitarInstagram())}

        return binding.root
    }

    private fun visitarFacebook() {
        val recurso = binding.tvFacebookLink.text.toString()
        if(recurso.isNotEmpty()) {

            val rutina = Intent(Intent.ACTION_VIEW, Uri.parse("http://$recurso"))
            startActivity(rutina)
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_datos),Toast.LENGTH_SHORT)
        }
    }

    private fun visitarInstagram() {
        val recurso = binding.tvInstagramLink.text.toString()
        if(recurso.isNotEmpty()) {

            val rutina = Intent(Intent.ACTION_VIEW, Uri.parse("http://$recurso"))
            startActivity(rutina)
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_datos),Toast.LENGTH_SHORT)
        }
    }

    private fun llamarLugar() {
        val recurso = binding.tvNumber.text.toString()
        if(recurso.isNotEmpty()) {

            val rutina = Intent(Intent.ACTION_CALL)
            rutina.data = Uri.parse("tel:$recurso")
            if(requireActivity().checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){

                requireActivity().requestPermissions(arrayOf(Manifest.permission.CALL_PHONE),
                    105)
            }else{
                requireActivity().startActivity(rutina)
            }
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_datos),Toast.LENGTH_SHORT)
        }
    }

    private fun escribirCorreo() {
        val recurso = binding.tvCorreoElectronico.text.toString()
        if(recurso.isNotEmpty()) {

            val rutina = Intent(Intent.ACTION_SEND)
            rutina.type="message/rfc822"
            rutina.putExtra(Intent.EXTRA_EMAIL, arrayOf(recurso))
            rutina.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.msg_saludos))
            rutina.putExtra(Intent.EXTRA_TEXT, getString(R.string.msg_mensaje_correo))
            startActivity(rutina)
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_datos), Toast.LENGTH_SHORT)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}