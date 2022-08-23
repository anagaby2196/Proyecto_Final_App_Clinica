package com.clinica_medica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.clinica_medica.databinding.ExpedienteFilaBinding
import com.clinica_medica.model.Expediente
import com.clinica_medica.ui.expediente.ExpedienteFragmentDirections


class ExpedienteAdapter : RecyclerView.Adapter<ExpedienteAdapter.ExpedienteViewHolder>() {

    private var datosExpediente = emptyList<Expediente>()

    inner class ExpedienteViewHolder(private val itemBinding: ExpedienteFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(expediente: Expediente) {
            itemBinding.tvNombrePaciente.text = expediente.nombrePaciente
            itemBinding.tvPadecimiento.text = expediente.padecimiento
            itemBinding.tvDia.text = expediente.dia
            itemBinding.tvFecha.text = expediente.fecha
            itemBinding.tvHora.text = expediente.hora
            itemBinding.tvNombreDoctor.text = expediente.nombreDoctor
            itemBinding.tvMedicamentos.text = expediente.medicamentos
            itemBinding.tvCuidados.text = expediente.cuidados

            itemBinding.vistaFilaExpediente.setOnClickListener {
                val accion = ExpedienteFragmentDirections.actionNavExpedienteToUpdateExpedienteFragment(expediente)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpedienteViewHolder {
        val itemBinding =
            ExpedienteFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpedienteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ExpedienteViewHolder, position: Int) {
        val expediente = datosExpediente[position]
        holder.dibuja(expediente)
    }

    override fun getItemCount(): Int {
        return datosExpediente.size
    }

    fun setData(expediente: List<Expediente>) {
        this.datosExpediente = expediente
        notifyDataSetChanged()
    }
}