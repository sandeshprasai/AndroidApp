package com.mobile.bce.network

object RetrofitClient {
    private  const val  Base_Url = "https://fakestoreapi.com/"

    val api: ApiInterface by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}