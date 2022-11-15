package com.example.frontendsegundoparcial

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.HashMap

data class ReservaTurnosResponse(@SerializedName("lista") val lista: List<Reservas>)

data class Reservas(
    @SerializedName("idReserva") var idReserva: Int? = null,
    @SerializedName("fechaCadena") var fechaCadena: String? = null,
    @SerializedName("fecha") var fechaReserva: String? = null,
    @SerializedName("horaInicioCadena") var horaInicioCadena: String? = null,
    @SerializedName("horaFinCadena") var horaFinCadena: String? = null,
    @SerializedName("flagEstado") var estadoReserva: String? = null,
    @SerializedName("idCliente") var idCliente: idCliente? = null,
    @SerializedName("nombre") var nombreCliente: String? = null,
    @SerializedName("apellido") var apellidoCliente: String? = null,
    @SerializedName("idEmpleado") var idEmplea: idEmpleado? = null,
    @SerializedName("observacion") var observacion: String? = null
)

data class idEmpleado(
    @SerializedName("idPersona") var idEmplea: Int? = null,
    @SerializedName("nombre") var nombreEmpleado: String? = null,
    @SerializedName("apellido") var apellidoEmpleado: String? = null
)

data class idCliente(
    @SerializedName("idPersona") var idPersona: String,
    @SerializedName("nombre") var nombreCliente: String,
    @SerializedName("apellido") var apellidoCliente: String
)