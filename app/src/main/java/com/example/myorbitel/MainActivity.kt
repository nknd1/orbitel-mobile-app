package com.example.myorbitel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.myorbitel.databinding.ActivityMainBinding
import com.example.myorbitel.presentation.fragments.ServiceListFragment
import com.example.myorbitel.presentation.fragments.home.HomeFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           binding = ActivityMainBinding.inflate(layoutInflater)
           Thread.sleep(3000)
           val splashScreen = installSplashScreen()

        setContentView(binding.root)
           replaceFragment(HomeFragment())

           binding.bottomNavigationView.setOnItemSelectedListener {

               when(it.itemId){

                   R.id.profile -> replaceFragment(HomeFragment())
                   R.id.tariffs -> replaceFragment(TariffDetailsFragment())
                   R.id.services -> replaceFragment(ServiceListFragment())

                   else ->{



                   }

               }

               true

           }


       }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }


    }

