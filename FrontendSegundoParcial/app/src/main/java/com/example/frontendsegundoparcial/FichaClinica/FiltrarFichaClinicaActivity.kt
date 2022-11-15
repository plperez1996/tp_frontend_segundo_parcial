package com.example.frontendsegundoparcial.FichaClinica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.APIService
import com.example.frontendsegundoparcial.AdministracionPacientes.ListAdapter
import com.example.frontendsegundoparcial.GetRetrofit
import com.example.frontendsegundoparcial.Lista
import com.example.frontendsegundoparcial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder

class FiltrarFichaClinicaActivity : AppCompatActivity() {
//    private lateinit var adapter : ListAdapter
    private val pacientesAdapter = mutableListOf<Lista>()
    private lateinit var svFichas : SearchView
    private lateinit var  rvList : RecyclerView
    private lateinit var  etDesde : EditText
    private lateinit var  etHasta : EditText
    private lateinit var rbFisio : RadioButton
    private lateinit var rbPac : RadioButton
    private lateinit var btnFiltrar : Button
    private lateinit var btBack: ImageButton
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filtrar_ficha_clinica)

        rvList = findViewById(R.id.rvInfo)
        rvList.layoutManager = LinearLayoutManager(this)

//        adapter = ListAdapter(pacientesAdapter)
//        rvList.adapter = adapter

        btnFiltrar = findViewById(R.id.btnFilter)

        svFichas = findViewById(R.id.svSearch)

        etDesde = findViewById(R.id.etDesde)
        etHasta = findViewById(R.id.etHasta)

        rbFisio = findViewById(R.id.rbFisio)
        rbPac = findViewById(R.id.rbPac)
        btBack = findViewById(R.id.BtnBack)

        btBack.setOnClickListener {
            finish()
        }

        btnFiltrar.setOnClickListener {
            if (rbPac.isChecked) {
                getFichaClinica("idCliente", svFichas.query.toString())
            } else if (rbFisio.isChecked) {
                getFichaClinica("idEmpleado", svFichas.query.toString())
            }
        }
    }

    private fun getFichaClinica(opcion: String, cadena: String) {
        val retrofit = GetRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit.getRetrofit().create(APIService::class.java).getFichaClinica("stock-nutrinatalia/fichaClinica?ejemplo=" + withContext(
            Dispatchers.IO
            ) {
            URLEncoder.encode("{\"$opcion\":\"$cadena\"}", "UTF-8")
        })
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {

                    }
                }
            }
        }
    }
}