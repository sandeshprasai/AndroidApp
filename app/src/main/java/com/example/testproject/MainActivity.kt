package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerlayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.formToolbar)
        setSupportActionBar(toolbar)

        val toogle= ActionBarDrawerToggle(
            this,drawerlayout,toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerlayout.addDrawerListener(toogle)
        toogle.syncState()
        //default fragment
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,Home())
                .commit()
            navigationView.setCheckedItem(R.id.nav_home)

        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.nav_home ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Home()).commit()
                }
                R.id.nav_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, About()).commit()
                }
                R.id.nav_Contact -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Contact()).commit()
                }
                R.id.nav_logout ->{
                    Toast.makeText(this,"Logged out successfully!", Toast.LENGTH_LONG).show()
                }

            }
            drawerlayout.closeDrawer(GravityCompat.START)
            true
        }







    }}