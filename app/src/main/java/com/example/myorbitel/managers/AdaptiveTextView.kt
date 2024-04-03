package com.example.myorbitel.managers
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
class AdaptiveTextView : AppCompatTextView {
    constructor(context: Context) : super(context){
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    private fun initialize() {
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels

        val textWidthRatio = 0.8
        val textHeightRatio = 0.5

        val textSize = (screenWidth * textWidthRatio + screenHeight * textHeightRatio) / 2

        setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        val textSizeInSp = 16
        val density = resources.displayMetrics.density
        val textSizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSizeInSp.toFloat(), resources.displayMetrics)

        gravity = android.view.Gravity.CENTER
    }
}