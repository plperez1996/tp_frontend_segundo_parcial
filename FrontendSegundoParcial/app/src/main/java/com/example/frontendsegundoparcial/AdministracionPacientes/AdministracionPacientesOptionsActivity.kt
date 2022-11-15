package com.example.frontendsegundoparcial.AdministracionPacientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.frontendsegundoparcial.R

class AdministracionPacientesOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administracion_pacientes_options)

        val btnCrear = findViewById<Button>(R.id.btnCrear)
        val btnFiltrar = findViewById<Button>(R.id.btnFiltrar)
        val btBack = findViewById<ImageButton>(R.id.BtnBack)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)

        btBack.setOnClickListener {
            finish()
        }

        btnFiltrar.setOnClickListener {
            val intent = Intent(this, AdministracionPacientesActivity::class.java)
            startActivity(intent)
        }

        btnCrear.setOnClickListener {
            val intent = Intent(this, CrearPersonaActivity::class.java)
            startActivity(intent)
        }
    }
}