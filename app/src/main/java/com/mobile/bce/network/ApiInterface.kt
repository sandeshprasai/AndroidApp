package com.mobile.bce.network

import com.mobile.bce.model.product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProducts(): Call<List<product>>

}