package com.example.frontendsegundoparcial.FichaClinica

data class GetFichasClinicaResponse (
    val lista: List<ListaFichas>? = null,
    val totalDatos: Long? = null
)

data class ListaFichas (
    val idFichaClinica: Long? = null,
    val fechaHora: String? = null,
    val motivoConsulta: String? = null,
    val diagnostico: String? = null,
    val observacion: String? = null,
    val idLocal: IDLocal? = null,
    val idEmpleado: idInfo? = null,
    val idCliente: idInfo? = null,
    val idTipoProducto: idTipoProduct? = null,
    val fechaHoraCadena: String? = null,
    val fechaHoraCadenaFormateada: String? = null,
    val fechaDesdeCadena: String? = null,
    val fechaHastaCadena: String? = null,
    val todosLosCampos: String? = null
)

data class idInfo (
    val idPersona: Long? = null,
    val nombre: String? = null,
    val apellido: String? = null,
    val email: String? = null,
    val telefono: String? = null,
    val seguroMedico: String? = null,
    val seguroMedicoNumero: String? = null,
    val ruc: String? = null,
    val cedula: String? = null,
    val tipoPersona: String? = null,
    val usuarioLogin: String? = null,
    val idLocalDefecto: IDLocal? = null,
    val flagVendedor: String? = null,
    val flagTaxfree: String? = null,
    val flagExcepcionChequeoVenta: String? = null,
    val observacion: String? = null,
    val direccion: String? = null,
    val idCiudad: String? = null,
    val tipoCliente: String? = null,
    val fechaHoraAprobContrato: String? = null,
    val soloUsuariosDelSistema: String? = null,
    val soloPersonasTaxfree: String? = null,
    val nombreCompleto: String? = null,
    val limiteCredito: Double? = null,
    val fechaNacimiento: String? = null,
    val soloProximosCumpleanhos: String? = null,
    val todosLosCampos: String? = null,
    val incluirLimiteDeCredito: String? = null,
    val deuda: String? = null,
    val saldo: String? = null,
    val creditos: String? = null
)

data class IDLocal (
    val idLocal: Long? = null,
    val nombre: String? = null,
    val flagCasaCentral: String? = null,
    val cantidadIngreso: Long? = null,
    val anhoMesActual: String? = null,
    val fechaHoraUltimoIngreso: String? = null,
    val minutosSesion: Long? = null,
    val nombreEmpresa: String? = null,
    val urlImagen: String? = null,
    val secuencia: String? = null,
    val pin: String? = null,
    val appMovil: String? = null,
    val qr: String? = null,
    val qrSoloEvaluacion: String? = null,
    val moneda: String? = null,
    val evaluacionItem: String? = null,
    val evaluacionLocal: String? = null,
    val habilitarFacebook: String? = null,
    val habilitarDatosManualmente: String? = null,
    val habilitarAnonimo: String? = null,
    val mostrarPreciosEnAccesoPublico: String? = null,
    val habilitarReserva: String? = null,
    val habilitarPedidosEnLocal: String? = null,
    val habilitarPedidosParaLlevar: String? = null,
    val habilitarPedidosDelivery: String? = null,
    val habilitarLlamarAlMozo: String? = null,
    val textoLamarAlMozo: String? = null,
    val textoRealizarPedido: String? = null,
    val recurso: String? = null,
    val flagRequiereAutorizacion: String? = null,
    val solicitarRucEnPedidos: String? = null,
    val costoDelivery: String? = null,
    val radioCoberturaDelivery: String? = null,
    val tiempoEntregaDelivery: String? = null,
    val posicionMapa: String? = null,
    val horaApertura: String? = null,
    val horaCierre: String? = null,
    val horariosEntregas: String? = null,
    val ultimaPublicacionShowMoreWeb: String? = null
)

data class idTipoProduct (
    val idTipoProducto: Long? = null,
    val descripcion: String? = null,
    val flagVisible: String? = null,
    val idCategoria: idCategoria? = null,
    val posicion: Long? = null
)

data class idCategoria (
    val idCategoria: Long? = null,
    val descripcion: String? = null,
    val flagVisible: String? = null,
    val posicion: Long? = null
)
