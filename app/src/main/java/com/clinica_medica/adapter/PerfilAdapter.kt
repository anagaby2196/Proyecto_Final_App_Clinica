package com.clinica_medica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.clinica_medica.databinding.PerfilFilaBinding
import com.clinica_medica.model.Perfil
import com.clinica_medica.ui.perfil.PerfilFragmentDirections

class PerfilAdapter : RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>() {

    private var datosPerfil = emptyList<Perfil>()

    inner class PerfilViewHolder(private val itemBinding: PerfilFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(datosPerfil : Perfil) {
            itemBinding.tvNombreUsuario.text = datosPerfil.nombreUsuario
            itemBinding.tvFechaNacimiento.text = datosPerfil.fechaNacimiento
            itemBinding.tvDireccion.text = datosPerfil.direccion
            itemBinding.tvPeso.text = datosPerfil.peso.toString()
            itemBinding.tvEstatura.text = datosPerfil.estatura.toString()
            itemBinding.tvNumeroTelefonico.text = datosPerfil.numeroTelefono.toString()
            itemBinding.tvCorreoElectronico.text = datosPerfil.correoElectronico
            itemBinding.tvHistorialMedico.text = datosPerfil.historial
            itemBinding.tvFechaCita.text = datosPerfil.fechaCita

            itemBinding.vistaFilaPerfil.setOnClickListener{
                val accion = PerfilFragmentDirections.actionNavPerfilToUpdatePerfilFragment(datosPerfil)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
        val itemBinding = PerfilFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PerfilViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
        val perfil = datosPerfil[position]
        holder.dibuja(perfil)
    }

    override fun getItemCount(): Int {
        return datosPerfil.size
    }

    fun setData(perfil : List<Perfil>) {
        this.datosPerfil = perfil
        notifyDataSetChanged()
    }
}