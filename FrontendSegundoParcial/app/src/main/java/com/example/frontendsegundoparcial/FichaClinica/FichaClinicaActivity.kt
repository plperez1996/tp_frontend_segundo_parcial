package com.example.frontendsegundoparcial.FichaClinica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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