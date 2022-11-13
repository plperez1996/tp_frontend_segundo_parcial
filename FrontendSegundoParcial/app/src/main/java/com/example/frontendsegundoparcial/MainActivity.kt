package com.example.frontendsegundoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLEncoder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdmPac = findViewById<Button>(R.id.btnAdmPac)
        val btnResTurno = findViewById<Button>(R.id.btnResTurn)

        btnAdmPac.setOnClickListener {
            val intent = Intent(this, AdministracionPacientesActivity::class.java)
            startActivity(intent)
        }

        btnResTurno.setOnClickListener{
            val intent = Intent(this, ReservaTurnosActivity::class.java)
            startActivity(intent)
        }
    }

}