package com.clinica_medica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.clinica_medica.databinding.CitaFilaBinding
import com.clinica_medica.model.Cita
import com.clinica_medica.ui.cita.CitaFragmentDirections


class CitaAdapter : RecyclerView.Adapter<CitaAdapter.CitaViewHolder>() {

    private var datosCita = emptyList<Cita>()

    inner class CitaViewHolder(private val itemBinding: CitaFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(cita: Cita) {
            itemBinding.tvNombrePaciente.text = cita.nombrePaciente
            itemBinding.tvPadecimiento.text = cita.padecimiento
            itemBinding.tvDia.text = cita.dia
            itemBinding.tvFecha.text = cita.fecha
            itemBinding.tvHora.text = cita.hora
            itemBinding.tvNombreDoctor.text = cita.nombreDoctor

            itemBinding.vistaFilaCita.setOnClickListener {
                val accion = CitaFragmentDirections.actionNavCitaToUpdateCitaFragment(cita)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val itemBinding =
            CitaFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CitaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val cita = datosCita[position]
        holder.dibuja(cita)
    }

    override fun getItemCount(): Int {
        return datosCita.size
    }

    fun setData(cita: List<Cita>) {
        this.datosCita = cita
        notifyDataSetChanged()
    }
}
