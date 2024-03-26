package com.example.myorbitel.managers
import android.content.Context
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.example.myorbitel.R

class BottomNavigationBarManager(private val context: Context, private val bottomNavigation: BottomNavigationView) {
    fun setupBottomNavigationBar(){
        val iconColorStateList =
            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primary))
        val textColorStateList =
            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primary))
        bottomNavigation.itemIconTintList = iconColorStateList
        bottomNavigation.itemTextColor = textColorStateList

        val iconColorStateListChecked = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked) // Используйте разные состояния для выбранных и невыбранных элементов
            ),
            intArrayOf(
                ContextCompat.getColor(context, R.color.primary),
                ContextCompat.getColor(context, R.color.gray)
            )
        )

        val textColorStateListChecked = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked)
            ),
            intArrayOf(
                ContextCompat.getColor(context, R.color.primary),
                ContextCompat.getColor(context, R.color.gray)
            )
        )
        bottomNavigation.itemIconTintList = iconColorStateListChecked
        bottomNavigation.itemTextColor = textColorStateListChecked
    }


}