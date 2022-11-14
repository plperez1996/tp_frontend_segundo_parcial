package com.example.frontendsegundoparcial

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url
import java.net.URLEncoder

interface APIService {

    @GET
    @Headers("Content-Type: application/json")
    suspend fun getAdministracionDePacientes(@Url url: String): Response<GetAdmiministracionPacientesResponse?>?


    @GET
    @Headers("Content-Type: application/json")
    suspend fun getReservas(@Url url: String): Response<List<Reservas>?>?

}