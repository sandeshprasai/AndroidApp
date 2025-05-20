package com.example.testproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val toolbar =  findViewById<androidx.appcompat.widget.Toolbar>(R.id.formToolbar)
        val btnRegister = findViewById<Button>(R.id.submitBtn)
        val txtResult = findViewById<TextView>(R.id.resultText)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }



     btnRegister.setOnClickListener{
         val fullName= findViewById<EditText>(R.id.editName)
         val email= findViewById<EditText>(R.id.editEmail)
         val address= findViewById<EditText>(R.id.editAddress)
         val gender= findViewById<RadioGroup>(R.id.radioBtn)
         val country = findViewById<Spinner>(R.id.selectCountry)
         val checkBox= findViewById<CheckBox>(R.id.checkbox)


         val nameData = fullName.text.toString()
         val emailData = email.text.toString()
         val addressData= address.text.toString()

         val genderGroup = gender.checkedRadioButtonId
         val genderText =findViewById<RadioButton>(genderGroup)?.text.toString()
         val countryData= country.selectedItem.toString()
         val acceptTerms = checkBox.isChecked.toString()

//         txtResult.setText("Name: " + nameData+ "\n" +  "Email: " + emailData+ "\n" + "Address: " + addressData + "\n" +
//                 "Gender: " + genderText+ "\n" +  "Country: " + countryData+ "\n" + "Terms: " + acceptTerms + "\n" )


         val intent  = Intent(this ,ResultActivity::class.java ).apply {
             putExtra("name", nameData)
             putExtra("email",emailData)
             putExtra("Address",addressData)
             putExtra("Gender",genderText)
             putExtra("Country",countryData)
             putExtra("Terms", acceptTerms)
         }

         startActivity(intent)

     }



    }
}