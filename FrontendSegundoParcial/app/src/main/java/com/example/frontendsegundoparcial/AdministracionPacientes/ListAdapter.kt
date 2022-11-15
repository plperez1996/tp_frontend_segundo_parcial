package com.example.frontendsegundoparcial.AdministracionPacientes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.Lista
import com.example.frontendsegundoparcial.R

class ListAdapter(val pacientes : List<Lista>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = pacientes[position]
        holder.nombre.text = p.nombre
        holder.apellido.text = p.apellido
        holder.fecha.text = p.fechaNacimiento
    }

    override fun getItemCount(): Int {
        return pacientes.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var nombre: TextView
        var apellido: TextView

        var fecha: TextView
        var tvIdFisio: TextView
        var tvidClient: TextView
        var tvIdFisioTitle: TextView
        var tvidClientTitle: TextView

        init {
            tvIdFisioTitle = v.findViewById(R.id.tvIdFisioTitle)
            tvidClientTitle = v.findViewById(R.id.tvidClientTitle)
            tvIdFisio = v.findViewById(R.id.tvIdFisio)
            tvidClient = v.findViewById(R.id.tvidClient)
            nombre = v.findViewById(R.id.tvNombre)
            apellido = v.findViewById(R.id.tvApellido)
            tvIdFisioTitle.visibility = View.GONE
            tvidClientTitle.visibility = View.GONE
            tvIdFisio.visibility = View.GONE
            tvidClient.visibility = View.GONE
            fecha = v.findViewById(R.id.tvFecha)
        }

        init {
            nombre = v.findViewById(R.id.tvNombre)
            apellido = v.findViewById(R.id.tvApellido)
        }
    }
}