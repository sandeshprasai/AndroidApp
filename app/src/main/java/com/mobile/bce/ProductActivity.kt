package com.mobile.bce

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bce.adapter.ProductAdapter
import com.mobile.bce.model.product
import com.mobile.bce.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ProductActivity : AppCompatActivity() {
    private lateinit var recyclerView :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        recyclerView = findViewById(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchProducts()
    }

    private fun fetchProducts() {
        RetrofitClient.api.getProducts()
            .enqueue(object : Callback<List<product>>{
                override fun onResponse(
                    call: Call<List<product>>,
                    response: Response<List<product>>
                ) {
                    if (response.isSuccessful)
                    {
                        val products = response.body()?: emptyList()
                        recyclerView.adapter = ProductAdapter(products)
                    }else
                    {
                        Toast.makeText(this@ProductActivity, "Failed to load ", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<List<product>>, t: Throwable) {
                    Toast.makeText(this@ProductActivity, "Error:${t.message}",Toast.LENGTH_LONG).show()
                }
    })
    }
}