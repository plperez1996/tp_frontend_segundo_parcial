package com.example.frontendsegundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frontendsegundoparcial.databinding.ActivityReservaTurnosBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLEncoder

class ReservaTurnosActivity : AppCompatActivity() {
    private lateinit var rgOptions : RadioGroup
    private lateinit var etFechaDesde : EditText
    private lateinit var etFechaHasta : EditText
    private lateinit var btnBuscar : Button
    private lateinit var binding:ActivityReservaTurnosBinding
    private lateinit var adapter: ReservasAdapter
    private lateinit var selectedOption : CharSequence
    private lateinit var btnBack: ImageButton
    private var reservas = mutableListOf<Reservas>()
    private var reservasCliente = mutableListOf<Lista>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservaTurnosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rgOptions = findViewById(R.id.rg_filtrado)
        etFechaDesde = findViewById(R.id.et_fecha_desde)
        etFechaHasta = findViewById(R.id.et_fecha_hasta)
        btnBuscar = findViewById(R.id.btn_buscar)
        btnBack = findViewById(R.id.BtnBack)

        btnBack.setOnClickListener {
            finish()
        }

        getByFisioAndDate("2", "20190903")
        rgOptions.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{
                group, checkedId ->
                val radio:  RadioButton = findViewById(checkedId)
                agregarCampos(radio.text)
                selectedOption = radio.text
            }
        )

        btnBuscar.setOnClickListener {
            when(selectedOption){
                "Empleado" -> {
                    if(etFechaDesde.text != null && etFechaHasta != null){
                        getByFisioAndDate(etFechaDesde.text.toString(), etFechaHasta.text.toString())
                    }else{
                        Toast.makeText(this, "Los campos no pueden quedar vacios", Toast.LENGTH_SHORT).show()
                    }
                }
                "Cliente" -> {
                    if (etFechaDesde.text != null){
                        getByClientId(etFechaDesde.text.toString())
                    }else{
                        Toast.makeText(this, "Los campos no pueden quedar vacios", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    }

    private fun initRecyclerView() {
        adapter = ReservasAdapter(reservas)
        binding.rvReserva.layoutManager = LinearLayoutManager(this)
        binding.rvReserva.adapter = adapter
    }

    private fun getRetrofit():Retrofit{
        val interceptor = HttpLoggingInterceptor()

        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://equipoyosh.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    private fun getByFisioAndDate(fisioId: String, date:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getReservas("stock-nutrinatalia/persona/$fisioId/agenda?fecha=$date")
            val reservasCall = call?.body()
            runOnUiThread{
                if(call?.isSuccessful!!){
                    val listaReservas = reservasCall
                    reservas.clear()
                    reservas.addAll(listaReservas!!)
                    initRecyclerView()
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show()
    }

    private fun getByClientId(cliendId: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getReservasByClientID("stock-nutrinatalia/reserva?ejemplo=" + withContext(
                Dispatchers.IO
            ){
                URLEncoder.encode("{\"idCliente\":{\"idPersona\":$cliendId}}", "UTF-8")
            })
            val reservasCall = call?.body()
            runOnUiThread {
                if (call?.isSuccessful!!){
                    val listaReservas = reservasCall
                    val reservasCliente = mutableListOf<Reservas>()
                    listaReservas!!.lista.forEach {
                        reservasCliente.add(Reservas(idEmplea = idEmpleado(nombreEmpleado = it.nombre)))
                    }
                    reservas.clear()
                    reservas.addAll(reservasCliente)
                    initRecyclerView()
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }
        }
    }

    private fun agregarCampos(opcion: CharSequence){
        when(opcion){
            "Empleado" ->{
                btnBuscar.visibility = View.VISIBLE
                etFechaDesde.visibility = View.VISIBLE
                etFechaDesde.hint = getString(R.string.empleado)
                etFechaHasta.visibility = View.VISIBLE
                etFechaHasta.hint = getString(R.string.fecha)
            }

            "Cliente" ->{
                btnBuscar.visibility = View.VISIBLE
                etFechaDesde.visibility = View.VISIBLE
                etFechaDesde.hint = getString(R.string.cliente)
                etFechaHasta.visibility = View.GONE
            }

            "Fecha" ->{
                btnBuscar.visibility = View.VISIBLE
                etFechaDesde.visibility = View.VISIBLE
                etFechaDesde.hint = getString(R.string.fecha_desde)
                etFechaHasta.visibility = View.VISIBLE
                etFechaHasta.hint = getString(R.string.fecha_hasta)
            }

        }
    }
}