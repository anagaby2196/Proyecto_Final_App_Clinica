package com.clinica_medica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.clinica_medica.databinding.PromocionFilaBinding
import com.clinica_medica.model.Promocion
import com.clinica_medica.ui.promocion.PromocionFragmentDirections

class PromocionAdapter : RecyclerView.Adapter<PromocionAdapter.PromocionViewHolder>() {

    private var listaPromociones = emptyList<Promocion>()

    inner class PromocionViewHolder(private val itemBinding: PromocionFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(promocion: Promocion) {
            itemBinding.tvNombrePromocion.text = promocion.nombrePromocion
            itemBinding.tvDescripcionPromocion.text = promocion.descripcion
            itemBinding.tvDescuento.text = promocion.descuento.toString()

            itemBinding.vistaFilaPromociones.setOnClickListener {
                val accion =
                    PromocionFragmentDirections.actionNavPromocionToUpdatePromocionFragment(
                        promocion
                    )
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromocionViewHolder {
        val itemBinding =
            PromocionFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromocionViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PromocionViewHolder, position: Int) {
        val promocion = listaPromociones[position]
        holder.dibuja(promocion)
    }

    override fun getItemCount(): Int {
        return listaPromociones.size
    }

    fun setData(promociones: List<Promocion>) {
        this.listaPromociones = promociones
        notifyDataSetChanged()
    }
}