package com.example.frontendsegundoparcial.FichaClinica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.frontendsegundoparcial.APIService
import com.example.frontendsegundoparcial.GetRetrofit
import com.example.frontendsegundoparcial.R
import com.example.frontendsegundoparcial.databinding.ActivityCrearFichaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearFichaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearFichaBinding
    private lateinit var etMotivo : EditText
    private lateinit var etDiagnostico: EditText
    private lateinit var etObservacion: EditText
    private lateinit var etIdEmpleado: EditText
    private lateinit var etIdCliente: EditText
    private lateinit var etIdTipoProducto: EditText
    private lateinit var btnRegistrarFicha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearFichaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etMotivo = findViewById(R.id.et_motivo)
        etDiagnostico = findViewById(R.id.et_diagnostico)
        etObservacion = findViewById(R.id.et_observacion)
        etIdEmpleado = findViewById(R.id.et_id_empleado)
        etIdCliente = findViewById(R.id.et_id_cliente)
        etIdTipoProducto = findViewById(R.id.et_id_producto)
        btnRegistrarFicha = findViewById(R.id.btn_registrar_ficha)

        btnRegistrarFicha.setOnClickListener {
            postFichaClinica(etMotivo.text.toString(), etDiagnostico.text.toString(),
            etObservacion.text.toString(), etIdEmpleado.text.toString(), etIdCliente.text.toString(), etIdTipoProducto.text.toString())
        }
    }

    private fun postFichaClinica( motivo: String, diagnostico: String, observacion: String,
                                    idEmpleado: String, idCliente: String, idProducto: String) {
        val retrofit = GetRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val request = PostFichaClinica(
                motivoConsulta = motivo,
                diagnostico = diagnostico,
                observacion = observacion,
                idEmpleado = IdFicha(idPersona = idEmpleado.toLong()),
                idCliente = IdFicha(idPersona = idCliente.toLong()),
                idTipoProducto = IdTipoProducto(idTipoProducto = idProducto.toLong())
            )
            val call = retrofit.getRetrofit().create(APIService::class.java).postFichaClinica("stock-nutrinatalia/fichaClinica", request)
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {
                        mostrarMensaje()
                    }
                }
            }
        }
    }

    private fun mostrarMensaje() {
        Toast.makeText(this, "Ficha Registrada Correctamente", Toast.LENGTH_SHORT).show()
    }
}
