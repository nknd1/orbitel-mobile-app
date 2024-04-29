package com.example.myorbitel.utils

import android.os.Message
import com.example.myorbitel.models.ErrorResponse

sealed class ApiResponse<out T>{
    data object Loading: ApiResponse<Nothing>()

    data class Success<out T>(
        val data: T
    ): ApiResponse<T>()

    data class Failure(
        val errorMessage: String,
        val code: Int,
    ): ApiResponse<Nothing>()
}