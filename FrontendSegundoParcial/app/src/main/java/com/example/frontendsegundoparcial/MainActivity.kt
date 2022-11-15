package com.example.frontendsegundoparcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.frontendsegundoparcial.AdministracionPacientes.AdministracionPacientesOptionsActivity
import com.example.frontendsegundoparcial.FichaClinica.FichaClinicaActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdmPac = findViewById<Button>(R.id.btnAdmPac)
        val btnResTurno = findViewById<Button>(R.id.btnResTurn)
        val btnfichClin = findViewById<Button>(R.id.btnFichClin)
        val btBack = findViewById<ImageButton>(R.id.BtnBack)

        btBack.visibility = View.GONE

        btnAdmPac.setOnClickListener {
            val intent = Intent(this, AdministracionPacientesOptionsActivity::class.java)
            startActivity(intent)
        }

        btnfichClin.setOnClickListener {
            val intent = Intent(this, FichaClinicaActivity::class.java)
            startActivity(intent)
        }

        btnResTurno.setOnClickListener{
            val intent = Intent(this, ReservaTurnosActivity::class.java)
            startActivity(intent)
        }
    }

}