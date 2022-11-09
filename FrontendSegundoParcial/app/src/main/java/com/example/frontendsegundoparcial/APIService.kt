package com.example.frontendsegundoparcial

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {

    @GET("stock-nutrinatalia/persona?inicio=0&cantidad=7&orderBy=apellido&orderDir=desc")
    @Headers("Content-Type: application/json")
    suspend fun getAdministracionDePacientes(): Response<GetAdmiministracionPacientesResponse?>?
}