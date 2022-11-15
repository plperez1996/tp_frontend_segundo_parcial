package com.example.frontendsegundoparcial.AdministracionPacientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.APIService
import com.example.frontendsegundoparcial.GetRetrofit
import com.example.frontendsegundoparcial.Lista
import com.example.frontendsegundoparcial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder

class AdministracionPacientesActivity : AppCompatActivity() {
    private lateinit var adapter : ListAdapter
    private val pacientesAdapter = mutableListOf<Lista>()
    private lateinit var svPacientes : SearchView
    private lateinit var  rvList : RecyclerView
    private lateinit var rbNombre : RadioButton
    private lateinit var rbApellido : RadioButton
    private lateinit var cbFisio : CheckBox
    private lateinit var btnFiltrar : Button
    private lateinit var btBack: ImageButton
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administracion_pacientes)
        rvList = findViewById(R.id.rvInfo)
        rvList.layoutManager = LinearLayoutManager(this)

        adapter = ListAdapter(pacientesAdapter)
        rvList.adapter = adapter

        btnFiltrar = findViewById(R.id.btnFilter)

        svPacientes = findViewById(R.id.svSearch)

        cbFisio = findViewById(R.id.cbFisio)
        rbNombre = findViewById(R.id.rbNombre)
        rbApellido = findViewById(R.id.rbApellido)
        btBack = findViewById(R.id.BtnBack)

        btBack.setOnClickListener {
            finish()
        }

        btnFiltrar.setOnClickListener {
            if (rbApellido.isChecked) {
                getAdmiminstracionPacientes("apellido", svPacientes.query.toString())
            } else if (rbNombre.isChecked) {
                getAdmiminstracionPacientes("nombre", svPacientes.query.toString())
            }
        }
    }

    private fun getAdmiminstracionPacientes(opcion: String = "", cadena: String = "") {
        val retrofit = GetRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit.getRetrofit().create(APIService::class.java).getAdministracionDePacientes("stock-nutrinatalia/persona?ejemplo=" + withContext(
                Dispatchers.IO
            ) {
                URLEncoder.encode("{\"$opcion\":\"$cadena\"}", "UTF-8")
            })
            val pacientesLista = call?.body()
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {
                        pacientesAdapter.clear()
                        pacientesAdapter.addAll(pacientesLista?.lista ?: emptyList())
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}