package com.example.frontendsegundoparcial.FichaClinica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.Lista
import com.example.frontendsegundoparcial.R

class FichaAdapter(val fichas : List<Lista>) : RecyclerView.Adapter<FichaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = fichas[position]
        holder.nombre.text = p.nombre
        holder.apellido.text = p.apellido
    }

    override fun getItemCount(): Int {
        return fichas.size
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