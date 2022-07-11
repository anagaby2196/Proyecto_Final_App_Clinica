package com.clinica_medica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.clinica_medica.databinding.ServicioFilaBinding
import com.clinica_medica.model.Servicio
import com.clinica_medica.ui.servicio.ServicioFragmentDirections

class ServicioAdapter : RecyclerView.Adapter<ServicioAdapter.ServicioViewHolder>() {

    private var listaServicios = emptyList<Servicio>()

    inner class ServicioViewHolder(private val itemBinding: ServicioFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(servicio : Servicio) {
            itemBinding.tvNombreServicio.text = servicio.nombreServicio
            itemBinding.tvDescripcionServicio.text = servicio.descripcion
            itemBinding.tvCosto.text = servicio.costo.toString()

            itemBinding.vistaFilaServicios.setOnClickListener{
                val accion = ServicioFragmentDirections.actionNavServicioToUpdateServicioFragment(servicio)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioViewHolder {
        val itemBinding = ServicioFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ServicioViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ServicioViewHolder, position: Int) {
        val servicio = listaServicios[position]
        holder.dibuja(servicio)
    }

    override fun getItemCount(): Int {
        return listaServicios.size
    }

    fun setData(servicios : List<Servicio>) {
        this.listaServicios = servicios
        notifyDataSetChanged()
    }
}