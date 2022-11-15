package com.example.frontendsegundoparcial.AdministracionPacientes

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.frontendsegundoparcial.APIService
import com.example.frontendsegundoparcial.GetRetrofit
import com.example.frontendsegundoparcial.Lista
import com.example.frontendsegundoparcial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CrearPersonaActivity : AppCompatActivity() {
    private lateinit var btnNuevo: Button
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var etEmail: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etRuc: EditText
    private lateinit var etFechNac: EditText
    private lateinit var etCedula: EditText
    private lateinit var cbSysUser: CheckBox
    private lateinit var btBack: ImageButton
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_persona)

        btnNuevo = findViewById(R.id.btnNuevo)
        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        etEmail = findViewById(R.id.etEmail)
        etTelefono = findViewById(R.id.etTelefono)
        etRuc = findViewById(R.id.etRuc)
        etFechNac = findViewById(R.id.etFechNac)
        etCedula = findViewById(R.id.etCedula)
        cbSysUser = findViewById(R.id.cbSystemUser)
        tvTitle = findViewById(R.id.tvTitle)
        btBack = findViewById(R.id.BtnBack)

        btBack.setOnClickListener {
            finish()
        }

        btnNuevo.setOnClickListener {
            crearPersona()
        }
    }

    fun crearPersona() {
        val retrofit = GetRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val request = Lista(nombre= etNombre.text.toString(),
                apellido = etApellido.text.toString(),
                email = etEmail.text.toString(),
                telefono = etTelefono.text.toString(),
                ruc = etRuc.text.toString(),
                cedula = etCedula.text.toString(),
                tipoPersona = "FISICA",
                fechaNacimiento ="1990-10-30 00:00:00",
                soloUsuariosDelSistema = true
            )

            val call = retrofit.getRetrofit().create(APIService::class.java).postCrearPersona("stock-nutrinatalia/persona", request)
            runOnUiThread {
                if (call != null) {
                    if (call.isSuccessful) {
                        Toast.makeText(this@CrearPersonaActivity, "El registro se realizo con exito!.", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@CrearPersonaActivity, "Error!. El registro ya existe.", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}