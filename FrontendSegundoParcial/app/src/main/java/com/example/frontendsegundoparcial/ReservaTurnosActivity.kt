package com.example.frontendsegundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class ReservaTurnosActivity : AppCompatActivity() {
    private lateinit var rgOptions : RadioGroup
    private lateinit var etFechaDesde : EditText
    private lateinit var etFechaHasta : EditText
    private lateinit var btnBuscar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva_turnos)

        rgOptions = findViewById(R.id.rg_filtrado)
        etFechaDesde = findViewById(R.id.et_fecha_desde)
        etFechaHasta = findViewById(R.id.et_fecha_hasta)
        btnBuscar = findViewById(R.id.btn_buscar)

        rgOptions.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{
                group, checkedId ->
                val radio:  RadioButton = findViewById(checkedId)
                agregarCampos(radio.text)

            }
        )

    }



    private fun agregarCampos(opcion: CharSequence){
        when(opcion){
            "Empleado" ->{
                btnBuscar.visibility = View.VISIBLE
                etFechaDesde.visibility = View.VISIBLE
                etFechaDesde.hint = getString(R.string.empleado)
                etFechaHasta.visibility = View.GONE
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