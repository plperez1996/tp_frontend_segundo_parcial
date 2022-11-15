package com.example.frontendsegundoparcial.FichaClinica

import com.google.gson.annotations.SerializedName

data class PostFichaClinica (
    @SerializedName("motivoConsulta") val motivoConsulta: String,
    @SerializedName("diagnostico") val diagnostico: String,
    @SerializedName("observacion") val observacion: String,
    @SerializedName("idEmpleado") val idEmpleado: IdFicha,
    @SerializedName("idCliente") val idCliente: IdFicha,
    @SerializedName("idTipoProducto") val idTipoProducto: IdTipoProducto
): java.io.Serializable

data class IdFicha (
    @SerializedName("idPersona") val idPersona: Long
): java.io.Serializable

data class IdTipoProducto (
    @SerializedName("idTipoProducto") val idTipoProducto: Long
): java.io.Serializable