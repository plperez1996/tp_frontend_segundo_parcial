package com.example.frontendsegundoparcial

import com.example.frontendsegundoparcial.FichaClinica.PostFichaClinica
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {

    @GET
    @Headers("Content-Type: application/json")
    suspend fun getAdministracionDePacientes(@Url url: String): Response<GetAdmiministracionPacientesResponse?>?

    @POST
    @Headers("Content-Type: application/json")
    suspend fun postCrearPersona(@Url url: String, @Body body: Lista) : Response<Void>

    @POST
    @Headers("Content-Type: application/json", "usuario: usuario5")
    suspend fun postFichaClinica(@Url url: String, @Body body: PostFichaClinica) : Response<Void>

    @POST
    @Headers("Content-Type: application/json", "usuario: usuario5")
    suspend fun getFichaClinica(@Url url: String) : Response<Void>

}