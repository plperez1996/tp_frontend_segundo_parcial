package com.example.frontendsegundoparcial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val pacientes : List<Lista>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = pacientes[position]
        holder.nombre.text = p.nombre
        holder.apellido.text = p.apellido
    }

    override fun getItemCount(): Int {
        return pacientes.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var nombre: TextView
        var apellido: TextView

        init {
            nombre = v.findViewById(R.id.tvNombre)
            apellido = v.findViewById(R.id.tvApellido)
        }
    }
}