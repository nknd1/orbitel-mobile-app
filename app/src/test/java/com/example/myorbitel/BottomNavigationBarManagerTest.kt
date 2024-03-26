package com.example.myorbitel
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import android.content.Context
import androidx.core.content.ContextCompat
import com.example.myorbitel.managers.BottomNavigationBarManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.junit.Test

@RunWith(MockitoJUnitRunner::class)
class BottomNavigationBarManagerTest {

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var bottomNavigationBarManager: BottomNavigationBarManager

    @Test
    fun testSetColorsForNavigationBarItems(){
        bottomNavigationBarManager = BottomNavigationBarManager(context)

        val selectedColor = ContextCompat.getColor(context, R.color.primary)
        val unselectedColor = ContextCompat.getColor(context, R.color.gray)

        BottomNavigationView(context)


    }
}