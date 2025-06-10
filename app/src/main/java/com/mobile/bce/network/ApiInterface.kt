package com.mobile.bce.network

import com.mobile.bce.model.product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("products")
    fun getProducts(): Call<List<product>>

    @POST("products")
    fun postProduct(@Body product: product): Call<product>
}