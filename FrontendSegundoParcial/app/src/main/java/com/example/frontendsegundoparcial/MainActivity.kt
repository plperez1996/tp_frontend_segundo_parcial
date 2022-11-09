package com.example.frontendsegundoparcial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var adapter : ListAdapter
    private val pacientesAdapter = mutableListOf<Lista>()
    private lateinit var svPacientes : SearchView
    private lateinit var svPacientes2 : SearchView
    private lateinit var svPacientes3 : SearchView
    private lateinit var  rvList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvList = findViewById(R.id.rvInfo)
        rvList.layoutManager = LinearLayoutManager(this)

        adapter = ListAdapter(pacientesAdapter)
        rvList.adapter = adapter

        svPacientes = findViewById(R.id.svSearch)
        svPacientes2 = findViewById(R.id.svSearch2)
        svPacientes3 = findViewById(R.id.svSearch3)

        svPacientes.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                getAdmiminstracionPacientes("N", query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    getAdmiminstracionPacientes()
                }
                return true
            }
        })


        svPacientes2.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                getAdmiminstracionPacientes("A", query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    getAdmiminstracionPacientes()
                }
                return true
            }
        })

        svPacientes3.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                getAdmiminstracionPacientes("C", query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    getAdmiminstracionPacientes()
                }
                return true
            }
        })

        getAdmiminstracionPacientes()

    }

    private fun getRetrofit(): Retrofit {
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

    private fun getAdmiminstracionPacientes(opcion: String = "", cadena: String = "") {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getAdministracionDePacientes()
            val pacientesLista = call?.body()
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {
                        pacientesAdapter.clear()
                        when (opcion) {
                            "N" -> {
                                pacientesAdapter.addAll(pacientesLista?.lista?.filter { it.nombre != null && it.nombre.lowercase() == cadena.lowercase() } ?: emptyList())
                            }
                            "A" -> {
                                pacientesAdapter.addAll(pacientesLista?.lista?.filter { it.apellido != null && it.apellido.lowercase() == cadena.lowercase() } ?: emptyList())
                            }
                            "C" -> {
                                pacientesAdapter.addAll(pacientesLista?.lista?.filter { it.nombre != null && it.nombre.lowercase().contains(cadena.lowercase()) } ?: emptyList())
                            }
                            else -> {
                                pacientesAdapter.addAll(pacientesLista?.lista ?: emptyList())
                            }
                        }
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}