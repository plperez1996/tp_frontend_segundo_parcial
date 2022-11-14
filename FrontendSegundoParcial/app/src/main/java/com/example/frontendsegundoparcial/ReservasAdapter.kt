package com.example.frontendsegundoparcial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ReservasAdapter(val reservas: List<Reservas>):RecyclerView.Adapter<ReservasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReservasViewHolder(layoutInflater.inflate(R.layout.item_reserva_rv, parent, false))
    }

    override fun onBindViewHolder(holder: ReservasViewHolder, position: Int) {
        val item: Reservas = reservas[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = reservas.size


}