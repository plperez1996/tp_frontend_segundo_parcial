package com.example.frontendsegundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.frontendsegundoparcial.FichaClinica.IdTipoProducto
import com.example.frontendsegundoparcial.FichaClinica.idInfo
import com.example.frontendsegundoparcial.databinding.ActivityCrearFichaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class CrearReservaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearFichaBinding
    private lateinit var etFecha : EditText
    private lateinit var etHoraInicio: EditText
    private lateinit var etHoraFin: EditText
    private lateinit var etIdEmpleado: EditText
    private lateinit var etIdCliente: EditText
    private lateinit var btnRegistrarReserva: Button
    private lateinit var btnBack: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_reserva)
        binding = ActivityCrearFichaBinding.inflate(layoutInflater)

        etFecha = findViewById(R.id.et_fecha)
        etHoraInicio = findViewById(R.id.et_hora_inicio)
        etHoraFin = findViewById(R.id.et_hora_fin)
        etIdEmpleado = findViewById(R.id.et_id_empleado)
        etIdCliente = findViewById(R.id.et_id_cliente)
        btnRegistrarReserva = findViewById(R.id.btn_registrar_reserva)
        btnBack = findViewById(R.id.BtnBack)

        btnBack.setOnClickListener {
            finish()
        }
        val intent = intent

        fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

        etFecha.text = intent.getStringExtra("fecha").toString().toEditable()
        etHoraFin.text = intent.getStringExtra("horaFin").toString().toEditable()
        etHoraInicio.text = intent.getStringExtra("horaInicio").toString().toEditable()

        btnRegistrarReserva.setOnClickListener {
            postReserva()
        }
    }

    private fun postReserva() {
        val retrofit = GetRetrofit()
        val fechaFormat: Date = SimpleDateFormat("yyyy-MM-dd").parse(etFecha.text.toString())
        val formatter = SimpleDateFormat("yyyyMMdd")
        val parsedDate: String = formatter.format(fechaFormat)
        CoroutineScope(Dispatchers.IO).launch {
            val request = PostReserva(
                fechaCadena = parsedDate,
                horaInicioCadena = etHoraInicio.text.toString(),
                horaFinCadena =  etHoraFin.text.toString(),
                idEmpleado = infoId(idPersona = etIdEmpleado.text.toString().toLong()),
                idCliente = infoId(idPersona = etIdCliente.text.toString().toLong()),
            )
            val call = retrofit.getRetrofit().create(APIService::class.java).postReserva("stock-nutrinatalia/reserva", request)
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {
                        Toast.makeText(this@CrearReservaActivity, "Reserva creada con exito!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}