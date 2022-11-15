package com.example.frontendsegundoparcial

data class PostReserva (
    val fechaCadena: String,
    val horaInicioCadena: String,
    val horaFinCadena: String,
    val idEmpleado: infoId,
    val idCliente: infoId
)

data class infoId (
    val idPersona: Long
)