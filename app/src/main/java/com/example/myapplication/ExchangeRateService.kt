package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExchangeRateService {

    @GET("")
    fun getExchangeRateApi(): Call<ArrayList<ExchangeRateServer>>

}