package com.example.frontendsegundoparcial.FichaClinica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.R
import java.text.SimpleDateFormat
import java.util.Date

class FichasAdapter (val pacientes : List<ListaFichas>) : RecyclerView.Adapter<FichasAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = pacientes[position]
        holder.nombre.text = p.idCliente?.nombre ?: ""
        holder.apellido.text = p.idEmpleado?.nombre ?: ""
        if (p.fechaHora != null){
            val initDateDesde: Date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(p.fechaHora)
            val formatter = SimpleDateFormat("dd-MM-yyyy")
            val parsedDate: String = formatter.format(initDateDesde) ?: ""
            holder.fecha.text = parsedDate
        }
        holder.idFisio.text = p.idEmpleado?.idPersona.toString() ?: ""
        holder.idCliente.text = p.idCliente?.idPersona.toString() ?: ""
    }

    override fun getItemCount(): Int {
        return pacientes.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var nombre: TextView
        var apellido: TextView

        var idCliente: TextView
        var idFisio: TextView

        var fecha: TextView

        var nombreTitle: TextView
        var apellidoTitle: TextView

        init {
            nombreTitle = v.findViewById(R.id.tvNombreTitle)
            apellidoTitle = v.findViewById(R.id.tvApellidoTitle)
            nombreTitle.text = "Cliente: "
            apellidoTitle.text = "Fisioterapeuta: "
            nombre = v.findViewById(R.id.tvNombre)
            apellido = v.findViewById(R.id.tvApellido)
            idFisio = v.findViewById(R.id.tvIdFisio)
            idCliente = v.findViewById(R.id.tvidClient)
            fecha = v.findViewById(R.id.tvFecha)
        }
    }
}