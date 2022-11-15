package com.example.frontendsegundoparcial.FichaClinica

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundoparcial.APIService
import com.example.frontendsegundoparcial.GetRetrofit
import com.example.frontendsegundoparcial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

class FiltrarFichaClinicaActivity : AppCompatActivity() {
    private lateinit var adapter : FichasAdapter
    private val pacientesAdapter = mutableListOf<ListaFichas>()
    private lateinit var svFichas : SearchView
    private lateinit var  rvList : RecyclerView
    private lateinit var  etDesde : EditText
    private lateinit var  etHasta : EditText
    private lateinit var rbFisio : RadioButton
    private lateinit var rbPac : RadioButton
    private lateinit var rbFecha : RadioButton
    private lateinit var btnFiltrar : Button
    private lateinit var btBack: ImageButton
    private lateinit var tvTitle: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filtrar_ficha_clinica)

        rvList = findViewById(R.id.rvFichas)
        rvList.layoutManager = LinearLayoutManager(this)

        adapter = FichasAdapter(pacientesAdapter)
        rvList.adapter = adapter

        btnFiltrar = findViewById(R.id.btnFilter)

        svFichas = findViewById(R.id.svSearch)

        etDesde = findViewById(R.id.etDesde)
        etHasta = findViewById(R.id.etHasta)

        rbFisio = findViewById(R.id.rbFisio)
        rbPac = findViewById(R.id.rbPac)
        rbFecha = findViewById(R.id.rbFechas)
        btBack = findViewById(R.id.BtnBack)

        btBack.setOnClickListener {
            finish()
        }

        rbPac.setOnClickListener {
            etDesde.visibility = View.GONE
            etHasta.visibility = View.GONE
        }

        rbFisio.setOnClickListener {
            etDesde.visibility = View.GONE
            etHasta.visibility = View.GONE
        }

        rbFecha.setOnClickListener {
            etDesde.visibility = View.VISIBLE
            etHasta.visibility = View.VISIBLE
        }

        btnFiltrar.setOnClickListener {
            if (!etDesde.text.toString().isEmpty() && !etHasta.text.toString().isEmpty() && etDesde.isVisible) {
                try {
                    val initDateDesde: Date = SimpleDateFormat("dd-MM-yyyy").parse(etDesde.text.toString())
                    val initDateHasta: Date = SimpleDateFormat("dd-MM-yyyy").parse(etHasta.text.toString())
                    val formatter = SimpleDateFormat("yyyyMMdd")
                    val parsedDate: String = formatter.format(initDateDesde)
                    val parsedDate2: String = formatter.format(initDateHasta)
                    getFichaClinica(cadena = parsedDate, cadena2 = parsedDate2)
                }catch (e: Exception) {
                    Toast.makeText(this@FiltrarFichaClinicaActivity, "Error en formato de fecha/s!!", Toast.LENGTH_LONG).show()
                }

            }else if (rbPac.isChecked) {
                getFichaClinica("idCliente", svFichas.query.toString())
            } else if (rbFisio.isChecked) {
                getFichaClinica("idEmpleado", svFichas.query.toString())
            }
        }
    }

    private fun getFichaClinica(opcion: String? = null, cadena: String? = null, cadena2: String? = null) {
        val retrofit = GetRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit.getRetrofit().create(APIService::class.java).getFichaClinica(
                if (cadena2 == null ){
                    "stock-nutrinatalia/fichaClinica?ejemplo=" + withContext(
                        Dispatchers.IO
                    ) {
                        URLEncoder.encode("{\"$opcion\":{\"idPersona\":$cadena}}", "UTF-8")
                    }
                } else {
                    "stock-nutrinatalia/fichaClinica?ejemplo=" + withContext(
                        Dispatchers.IO
                    ) {
                        URLEncoder.encode("{\"fechaDesdeCadena\":\"$cadena\",\"fechaHastaCadena\":\"$cadena2\"}", "UTF-8")
                    }
            })
            runOnUiThread {
                if (call != null) {
                    val pacientesLista = call?.body()
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