package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationMenu= findViewById<NavigationView>(R.id.nav_view)
        val toolbar =findViewById<androidx.appcompat.widget.Toolbar>(R.id.formToolbar)

        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this, drawerLayout,toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close

        )

        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

//        val btnClick = findViewById<Button>(R.id.clickMe)
//        btnClick.setOnClickListener{
//            val intent =Intent(this, FormActivity::class.java)
//            startActivity(intent)
//        }

    }
}