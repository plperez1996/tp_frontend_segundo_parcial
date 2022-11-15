package com.example.frontendsegundoparcial

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.databinding.ItemReservaRvBinding

class ReservasViewHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener {

    private val binding = ItemReservaRvBinding.bind(view)
    val btnGuardar = binding.btnGuardar
    val context = view.context
    lateinit var reserva : Reservas

    fun bind(reserva: Reservas){

        this.reserva = reserva
        binding.tvFisioNombre.text = reserva.idEmplea!!.nombreEmpleado
        binding.tvPacienteNombre.text = reserva.idCliente?.nombreCliente ?: ""
        binding.tvFecha.text = reserva.fechaReserva ?: ""
    }

    fun setOnClickListeners() {
        btnGuardar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent(context, CrearReservaActivity::class.java)
        intent.putExtra("fecha", reserva.fechaReserva)
        intent.putExtra("horaInicio", reserva.horaInicioCadena)
        intent.putExtra("horaFin", reserva.horaFinCadena)
        context.startActivity(intent)
    }
}