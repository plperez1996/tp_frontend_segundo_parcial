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
    @SerializedName("creditos") val creditos: String? = null
): java.io.Serializable