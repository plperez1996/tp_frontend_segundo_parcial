package com.example.frontendsegundoparcial

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.databinding.ItemReservaRvBinding

class ReservasViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemReservaRvBinding.bind(view)

    fun bind(reserva: Reservas){

        binding.tvFisioNombre.text = reserva.idEmplea!!.nombreEmpleado
        binding.tvPacienteNombre.text = reserva.idCliente?.nombreCliente
        binding.tvFecha.text = reserva.fechaReserva

    }
}