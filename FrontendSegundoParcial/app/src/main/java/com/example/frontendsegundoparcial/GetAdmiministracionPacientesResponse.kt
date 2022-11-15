package com.example.frontendsegundoparcial

import com.google.gson.annotations.SerializedName

data class GetAdmiministracionPacientesResponse (
    @SerializedName("lista") val lista: List<Lista>,
    @SerializedName("totalDatos") val totalDatos: Long
)

data class Lista (
    @SerializedName("idPersona") val idPersona: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("apellido") val apellido: String? = null,
    @SerializedName("email") val email: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("seguroMedico") val seguroMedico: String? = null,
    @SerializedName("seguroMedicoNumero") val seguroMedicoNumero: String? = null,
    @SerializedName("ruc") val ruc: String,
    @SerializedName("cedula") val cedula: String? = null,
    @SerializedName("tipoPersona") val tipoPersona: String,
    @SerializedName("usuarioLogin") val usuarioLogin: String? = null,
    @SerializedName("idLocalDefecto") val idLocalDefecto: String? = null,
    @SerializedName("flagVendedor") val flagVendedor: String,
    @SerializedName("flagTaxfree") val flagTaxfree: String? = null,
    @SerializedName("flagExcepcionChequeoVenta") val flagExcepcionChequeoVenta: String,
    @SerializedName("observacion") val observacion: String? = null,
    @SerializedName("direccion") val direccion: String? = null,
    @SerializedName("idCiudad") val idCiudad: String? = null,
    @SerializedName("tipoCliente") val tipoCliente: String,
    @SerializedName("fechaHoraAprobContrato") val fechaHoraAprobContrato: String? = null,
    @SerializedName("soloUsuariosDelSistema") val soloUsuariosDelSistema: String? = null,
    @SerializedName("soloPersonasTaxfree") val soloPersonasTaxfree: String? = null,
    @SerializedName("nombreCompleto") val nombreCompleto: String,
    @SerializedName("limiteCredito") val limiteCredito: Double,
    @SerializedName("fechaNacimiento") val fechaNacimiento: String,
    @SerializedName("soloProximosCumpleanhos") val soloProximosCumpleanhos: String? = null,
    @SerializedName("todosLosCampos") val todosLosCampos: String? = null,
    @SerializedName("incluirLimiteDeCredito") val incluirLimiteDeCredito: String? = null,
    @SerializedName("deuda") val deuda: String? = null,
    @SerializedName("saldo") val saldo: String? = null,
    @SerializedName("creditos") val creditos: String? = null,
    @SerializedName("fecha") val fecha: String? = null,
    @SerializedName("idCliente") val idCliente: idCliente? = null,
    @SerializedName("idEmpleado") val idEmplea: idEmpleado? = null
)