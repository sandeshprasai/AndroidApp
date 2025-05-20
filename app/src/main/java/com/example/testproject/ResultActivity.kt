package com.example.testproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val address = intent.getStringExtra("Address")
        val gender = intent.getStringExtra("Gender")
        val country = intent.getStringExtra("Country")
        val terms = intent.getStringExtra("Terms")

        val txtResult  = findViewById<TextView>(R.id.txt_Result)
        txtResult.text = """
    Name:$name
    Email:$email
    Address:$address
    Gender:$gender
    Country:$country
    Accepted Terms:$terms
    """.trimIndent()

    }


}