package com.e.revisaowebservice.service

import com.e.revisaowebservice.entities.Aluno
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Service {
    //aqui dentro passamos os end points de acesso à API

    @GET("alunos")
    suspend fun getResultsRepo() : ArrayList<Aluno>


}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"
val urlApiPromo = "https://promoios.com.br/api/"
var urlRickMorty = "https://rickandmortyapi.com/api/"
var urlSortUser ="https://randomuser.me/api"



val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(urlApiPromo)
    .build()

val service: Service = retrofit.create(Service::class.java)