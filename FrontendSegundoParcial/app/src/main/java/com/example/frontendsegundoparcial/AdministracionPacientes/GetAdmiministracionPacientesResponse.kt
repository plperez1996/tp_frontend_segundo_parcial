package com.example.frontendsegundoparcial

import com.google.gson.annotations.SerializedName

data class GetAdmiministracionPacientesResponse (
    @SerializedName("lista") val lista: List<Lista>,
    @SerializedName("totalDatos") val totalDatos: Long
) : java.io.Serializable

data class Lista (
    @SerializedName("idPersona") val idPersona: Long? = null,
    @SerializedName("nombre") val nombre: String? = null,
    @SerializedName("apellido") val apellido: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("telefono") val telefono: String? = null,
    @SerializedName("seguroMedico") val seguroMedico: String? = null,
    @SerializedName("seguroMedicoNumero") val seguroMedicoNumero: String? = null,
    @SerializedName("ruc") val ruc: String? = null,
    @SerializedName("cedula") val cedula: String? = null,
    @SerializedName("tipoPersona") val tipoPersona: String? = null,
    @SerializedName("usuarioLogin") val usuarioLogin: String? = null,
    @SerializedName("idLocalDefecto") val idLocalDefecto: String? = null,
    @SerializedName("flagVendedor") val flagVendedor: String? = null,
    @SerializedName("flagTaxfree") val flagTaxfree: String? = null,
    @SerializedName("flagExcepcionChequeoVenta") val flagExcepcionChequeoVenta: String? = null,
    @SerializedName("observacion") val observacion: String? = null,
    @SerializedName("direccion") val direccion: String? = null,
    @SerializedName("idCiudad") val idCiudad: String? = null,
    @SerializedName("tipoCliente") val tipoCliente: String? = null,
    @SerializedName("fechaHoraAprobContrato") val fechaHoraAprobContrato: String? = null,
    @SerializedName("soloUsuariosDelSistema") val soloUsuariosDelSistema: Boolean? = null,
    @SerializedName("soloPersonasTaxfree") val soloPersonasTaxfree: String? = null,
    @SerializedName("nombreCompleto") val nombreCompleto: String? = null,
    @SerializedName("limiteCredito") val limiteCredito: Double? = null,
    @SerializedName("fechaNacimiento") val fechaNacimiento: String? = null,
    @SerializedName("soloProximosCumpleanhos") val soloProximosCumpleanhos: String? = null,
    @SerializedName("todosLosCampos") val todosLosCampos: String? = null,
    @SerializedName("incluirLimiteDeCredito") val incluirLimiteDeCredito: String? = null,
    @SerializedName("deuda") val deuda: String? = null,
    @SerializedName("saldo") val saldo: String? = null,
    @SerializedName("creditos") val creditos: String? = null,
    @SerializedName("idEmpleado") val idEmpleado: idInfo? = null,
    @SerializedName("idCliente") val idCliente: idInfo? = null
): java.io.Serializable


data class idInfo (
    val idPersona: Long,
    val nombre: String,
    val apellido: String? = null,
    val email: String? = null,
    val telefono: String? = null,
    val seguroMedico: Any? = null,
    val seguroMedicoNumero: Any? = null,
    val ruc: String? = null,
    val cedula: String? = null,
    val tipoPersona: String? = null,
    val usuarioLogin: String? = null,
    val idLocalDefecto: String? = null,
    val flagVendedor: String? = null,
    val flagTaxfree: Any? = null,
    val flagExcepcionChequeoVenta: String? = null,
    val observacion: Any? = null,
    val direccion: Any? = null,
    val idCiudad: Any? = null,
    val tipoCliente: String? = null,
    val fechaHoraAprobContrato: Any? = null,
    val soloUsuariosDelSistema: Any? = null,
    val soloPersonasTaxfree: Any? = null,
    val nombreCompleto: String,
    val limiteCredito: Double,
    val fechaNacimiento: String? = null,
    val soloProximosCumpleanhos: Any? = null,
    val todosLosCampos: Any? = null,
    val incluirLimiteDeCredito: Any? = null,
    val deuda: Any? = null,
    val saldo: Any? = null,
    val creditos: Any? = null
)