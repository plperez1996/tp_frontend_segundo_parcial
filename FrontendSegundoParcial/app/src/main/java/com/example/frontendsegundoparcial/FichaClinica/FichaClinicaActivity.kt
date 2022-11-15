package com.example.frontendsegundoparcial.FichaClinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.frontendsegundoparcial.APIService
import com.example.frontendsegundoparcial.GetRetrofit
import com.example.frontendsegundoparcial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FichaClinicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_clinica)

        val btnCrear = findViewById<Button>(R.id.btnCrear)
        val btnFiltrar = findViewById<Button>(R.id.btnFiltrar)
        val btBack = findViewById<ImageButton>(R.id.BtnBack)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)

        btBack.setOnClickListener {
            finish()
        }

        btnFiltrar.setOnClickListener {
            val intent = Intent(this, FiltrarFichaClinicaActivity::class.java)
            startActivity(intent)
        }

        btnCrear.setOnClickListener {
            val intent = Intent(this, CrearFichaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun postFichaClinica() {
        val retrofit = GetRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val request = PostFichaClinica(
                motivoConsulta = "dolor en la rodilla",
                diagnostico = "lesion leve, fisioterapia 10 sesiones",
                observacion = "nada grave",
                idEmpleado = IdFicha(idPersona = 2),
                idCliente = IdFicha(idPersona = 2),
                idTipoProducto = IdTipoProducto(idTipoProducto = 250)
            )
            val call = retrofit.getRetrofit().create(APIService::class.java).postFichaClinica("stock-nutrinatalia/fichaClinica", request)
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {

                    }
                }
            }
        }
    }
}