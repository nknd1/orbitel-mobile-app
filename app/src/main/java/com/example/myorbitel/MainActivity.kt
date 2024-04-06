package com.example.myorbitel

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myorbitel.managers.BottomNavigationBarManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.intuit.sdp.BuildConfig
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // Release mode logging
        }
        setContentView(R.layout.activity_main)







        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btm_nav)
        val bottomNavigationManager = BottomNavigationBarManager(this, bottomNavigation)
        bottomNavigationManager.setupBottomNavigationBar()
        val backgroundColor = ContextCompat.getColor(this, R.color.white)
        bottomNavigation.setBackgroundColor(backgroundColor)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigation, navController)

    }
}
